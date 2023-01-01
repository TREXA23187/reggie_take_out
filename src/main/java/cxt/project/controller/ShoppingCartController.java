package cxt.project.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import cxt.project.common.BaseContext;
import cxt.project.common.Result;
import cxt.project.entity.ShoppingCart;
import cxt.project.service.ShoppingCartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 地址簿管理
 */
@Slf4j
@RestController
@RequestMapping("/shoppingCart")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @PostMapping
    public Result<ShoppingCart> add(@RequestBody ShoppingCart shoppingCart){
        Long currentId = BaseContext.getCurrentId();
        shoppingCart.setUserId(currentId);

        Long dishId = shoppingCart.getDishId();

        LambdaQueryWrapper<ShoppingCart> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ShoppingCart::getUserId, currentId);

         if(dishId != null){
            queryWrapper.eq(ShoppingCart::getDishId, dishId);
        }else {
             queryWrapper.eq(ShoppingCart::getSetmealId, shoppingCart.getSetmealId());
         }

        ShoppingCart cartServiceOne = shoppingCartService.getOne(queryWrapper);

         if(cartServiceOne != null){
             Integer number = cartServiceOne.getNumber();
             cartServiceOne.setNumber(number + 1);

             shoppingCartService.updateById(cartServiceOne);
         }else {
             shoppingCart.setNumber(1);
             shoppingCartService.save(shoppingCart);
             cartServiceOne = shoppingCart;
         }

         return Result.success(cartServiceOne);
    }

    @GetMapping("/list")
    public Result<List<ShoppingCart>> list(){
        List<ShoppingCart> list = shoppingCartService.list();

        return Result.success(list);
    }


}
