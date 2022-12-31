package cxt.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cxt.project.entity.Dish;
import cxt.project.mapper.DishMapper;
import cxt.project.service.DishService;
import org.springframework.stereotype.Service;

@Service
public class DishServiceImpl extends ServiceImpl<DishMapper, Dish> implements DishService {

}
