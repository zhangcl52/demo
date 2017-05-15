package com.hunter.sys.mapper;import com.hunter.sys.entity.SysMenu;import org.apache.ibatis.annotations.ResultMap;import org.apache.ibatis.annotations.Select;import java.util.List;/** * @Author zhangcl * @Date 17/5/9  上午6:22 */public interface SysMenuMapper {    /**     * 获取一级菜单     * @return     */    @Select("select * from sys_menu a where a.is_del=0 and parent_id=0")    @ResultMap("com.hunter.sys.dao.SysMenuDao.allResultMap")    List<SysMenu> getAllTopMenu();    /**     * 获取所有的菜单     * @return     */    @Select("select * from sys_menu a where a.is_del=0")    @ResultMap("com.hunter.sys.dao.SysMenuDao.allResultMap")    List<SysMenu> getAllMenu();    /**     * 根据id获取数据     * @return     */    @Select("select * from sys_menu a where a.is_del=0 and id=?")    @ResultMap("com.hunter.sys.dao.SysMenuDao.allResultMap")    SysMenu findById(long id);}