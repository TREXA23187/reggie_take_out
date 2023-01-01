package cxt.project.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import cxt.project.entity.AddressBook;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AddressBookMapper extends BaseMapper<AddressBook> {
}
