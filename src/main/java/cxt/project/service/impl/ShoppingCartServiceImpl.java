package cxt.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cxt.project.entity.ShoppingCart;
import cxt.project.mapper.ShoppingCartMapper;
import cxt.project.service.ShoppingCartService;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImpl extends ServiceImpl<ShoppingCartMapper, ShoppingCart> implements ShoppingCartService {

}
