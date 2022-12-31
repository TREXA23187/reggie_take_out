package cxt.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cxt.project.dto.DishDto;
import cxt.project.entity.Dish;

public interface DishService extends IService<Dish> {
    public void saveWithFlavor(DishDto dishDto);

    public DishDto getByIdWithFlavor(Long id);

    public void updateWithFlavor(DishDto dishDto);
}
