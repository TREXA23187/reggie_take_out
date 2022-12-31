package cxt.project.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import cxt.project.entity.Dish;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DishMapper extends BaseMapper<Dish> {
}
