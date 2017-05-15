package com.hunter.sys.controller;import com.alibaba.fastjson.JSONObject;import com.alibaba.fastjson.serializer.SerializerFeature;import com.google.common.base.Strings;import com.google.common.collect.Maps;import com.hunter.base.vo.RequestData;import com.hunter.common.constant.BaseConstant;import com.hunter.common.constant.SysConstant;import com.hunter.sys.entity.SysMenu;import com.hunter.sys.service.SysMenuService;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Controller;import org.springframework.ui.ModelMap;import org.springframework.web.bind.annotation.RequestMapping;import org.springframework.web.bind.annotation.RequestMethod;import org.springframework.web.bind.annotation.ResponseBody;import javax.servlet.http.HttpServletRequest;import java.util.Date;import java.util.List;import java.util.Map;/** * @Author zhangcl * @Date 16/7/9  下午6:07 */@Controller@RequestMapping("/sys/menu")public class SysMenuController {    @Autowired    SysMenuService sysMenuService;    /**     * 请求列表     * @param request     * @param modelMap     * @return     */    @RequestMapping(value = "/list")    public String list(HttpServletRequest request, ModelMap modelMap) {        return "sys/menu/listMenu";    }    /**     * ajax请求     *     * @param requestData     * @return     */    @RequestMapping(value = "/ajax/list", produces = "application/json;charset=UTF-8")    @ResponseBody    public String ajaxList(RequestData requestData) {        List<SysMenu> sysMenuList = sysMenuService.getAllMenu();        Map<String, Object> map = Maps.newHashMap();        map.put("recordsTotal", sysMenuList.size());        map.put("recordsFiltered", sysMenuList.size() );        map.put("draw", requestData.getDraw());        map.put("data", sysMenuList);        String resultJson = JSONObject.toJSONString(map, SerializerFeature.PrettyFormat);        return resultJson;    }    /**     * 跳转到增加页面     *     * @param request     * @param modelMap     * @return     */    @RequestMapping(value = "/add", method = RequestMethod.GET)    public String add(HttpServletRequest request, ModelMap modelMap) {        String id = request.getParameter("id");        SysMenu sysMenu = new SysMenu();        if (!Strings.isNullOrEmpty(id)) {            sysMenu = sysMenuService.findById(Long.valueOf(id));        }        modelMap.put("menu", sysMenu);        return "sys/menu/addMenu";    }    /**     * 保存     * @param request     * @param sysMenu     * @param modelMap     * @return     */    @RequestMapping(value="/save",method = RequestMethod.POST)    public String save(HttpServletRequest request,SysMenu sysMenu,ModelMap modelMap){        long id=sysMenu.getId();        Date now =new Date();        sysMenu.setModifyTime(now);        sysMenu.setModifyName(SysConstant.ZCL);        if(id==0){            sysMenu.setParentId(BaseConstant.INT_0);            sysMenu.setCreateTime(now);            sysMenu.setCreateName(SysConstant.ZCL);            sysMenuService.save(sysMenu);        }        sysMenuService.update(sysMenu);        return "redirect:list.do";    }}