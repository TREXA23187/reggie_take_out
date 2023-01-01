package cxt.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cxt.project.entity.AddressBook;
import cxt.project.mapper.AddressBookMapper;
import cxt.project.service.AddressBookService;
import org.springframework.stereotype.Service;

@Service
public class AddressBookServiceImpl extends ServiceImpl<AddressBookMapper, AddressBook> implements AddressBookService {

}
