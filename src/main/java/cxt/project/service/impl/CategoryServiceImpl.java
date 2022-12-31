package cxt.project.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cxt.project.common.CustomException;
import cxt.project.entity.Category;
import cxt.project.entity.Dish;
import cxt.project.entity.Setmeal;
import cxt.project.mapper.CategoryMapper;
import cxt.project.service.CategoryService;
import cxt.project.service.DishService;
import cxt.project.service.SetmealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Autowired
    private DishService dishService;

    @Autowired
    private SetmealService setmealService;

    @Override
    public void remove(Long id) {
        LambdaQueryWrapper<Dish> dishLambdaQueryWrapper = new LambdaQueryWrapper<>();
        dishLambdaQueryWrapper.eq(Dish::getCategoryId, id);

        int countDish = dishService.count(dishLambdaQueryWrapper);
        if(countDish>0){
            throw new CustomException("links to a dish, cannot be deleted");
        }

        LambdaQueryWrapper<Setmeal> setmealLambdaQueryWrapper = new LambdaQueryWrapper<>();
        setmealLambdaQueryWrapper.eq(Setmeal::getCategoryId, id);
        int countSetmeal = setmealService.count(setmealLambdaQueryWrapper);
        if(countSetmeal>0){
            throw new CustomException("links to a setmeal, cannot be deleted");
        }

        super.removeById(id);

    }
}
