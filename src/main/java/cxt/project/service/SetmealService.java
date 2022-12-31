package cxt.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cxt.project.dto.SetmealDto;
import cxt.project.entity.Setmeal;

import java.util.List;

public interface SetmealService extends IService<Setmeal> {
    public void saveWithDish(SetmealDto setmealDto);

    public void removeWithDish(List<Long> ids);
}
