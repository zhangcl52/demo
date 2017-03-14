package com.hunter.base.dao;import com.google.common.collect.Maps;import com.hunter.common.constant.BaseConstant;import org.mybatis.spring.SqlSessionTemplate;import org.slf4j.Logger;import org.slf4j.LoggerFactory;import java.lang.reflect.Method;import java.util.List;import java.util.Map;/** * @Author zhangcl * @Date 16/7/4  下午10:51 */public class MybatisBaseDao<T> implements IBaseDao<T> {    private static Logger LOGGER= LoggerFactory.getLogger(MybatisBaseDao.class);    private String nameSpace;    /**     * 暂不支持一主多从     */    private SqlSessionTemplate masterSqlSessionTemplate;    private SqlSessionTemplate slaveSqlSessionTemplate;    private static String FIND_ONE_BY_ID = "findOneById";    private static String INSERT = "insert";    private static String DELETE_BY_ID="deleteById";    private static String DELETE_BY_IDS="deleteByIds";    private static String UPDATE_BY_ENTITY="updateByEntity";    public MybatisBaseDao() {    }    public void setNameSpace(String nameSpace) {        this.nameSpace = nameSpace;    }    public void setMasterSqlSessionTemplate(SqlSessionTemplate masterSqlSessionTemplate) {        this.masterSqlSessionTemplate = masterSqlSessionTemplate;    }    public void setSlaveSqlSessionTemplate(SqlSessionTemplate slaveSqlSessionTemplate) {        this.slaveSqlSessionTemplate = slaveSqlSessionTemplate;    }    //    private SqlSessionTemplate chooseDataSource() {//        if (TransactionContext.isInTransaction()) {//            return this.masterSqlSessionTemplate;//        }//        return this.slaveSqlSessionTemplate;//    }    @Override    public long countBySql(String sql, Map param) {        return slaveSqlSessionTemplate.selectOne(getStatement(sql), param);    }    @Override    public T findOneById(long id) {        List<T> list = slaveSqlSessionTemplate.selectList(getStatement(FIND_ONE_BY_ID), id);        if (list != null && list.size() == 1) {            return list.get(0);        }        return null;    }    @Override    public T findOneBySql(String sql, Map param) {        List<T> list = slaveSqlSessionTemplate.selectList(getStatement(sql), param);        if (list != null && list.size() == 1) {            return list.get(0);        }        return null;    }    @Override    public List findListBySql(String sql, Map param) {        List list = slaveSqlSessionTemplate.selectList(getStatement(sql), param);        if (list != null && list.size() > 0) {            return list;        }        return null;    }    @Override    public List findListBySql(String sql) {        List list = slaveSqlSessionTemplate.selectList(getStatement(sql));        if (list != null && list.size() > 0) {            return list;        }        return null;    }    @Override    public int insert(Object entity) {        int id=slaveSqlSessionTemplate.insert(getStatement(INSERT));        return id;    }    @Override    public int updateBySql(String sql, Map param) {        return masterSqlSessionTemplate.update(sql,param);    }    @Override    public int deleteById(long id) {        return masterSqlSessionTemplate.delete(getStatement(DELETE_BY_ID),id);    }    @Override    public int deleteByIds(List ids) {        Map<String,Object> paraMap= Maps.newHashMap();        paraMap.put("ids",ids);        return masterSqlSessionTemplate.delete(getStatement(DELETE_BY_IDS),paraMap);    }    @Override    public int deleteBySql(String sql, Map param) {        return masterSqlSessionTemplate.delete(getStatement(DELETE_BY_ID),param);    }    /**     * 获得sqlid     *     * @param sqlId     * @return     */    private String getStatement(String sqlId) {        return nameSpace + BaseConstant.PERIOD + sqlId;    }    /**     * 更新实体类     * @param t     */    private void update(T t) throws Exception{       Map<String,Object> paramMap=Maps.newHashMap();        Class tClass=t.getClass();        //得到所有的方法        Method[] methods = tClass.getMethods();        for(Method method:methods){            if(method.getName().startsWith("get")){                try{                    String fieldName=method.getName().substring(BaseConstant.INT_3);                    //将首字母小写                    fieldName=fieldName.substring(0,1).toLowerCase()+fieldName.substring(1);                    Object object =method.invoke(t);                    paramMap.put(fieldName,object);                }catch (Exception e){                    LOGGER.error("能过反射获取对象属性出错",e);                    throw new RuntimeException("能过反射获取对象属性出错", e);                }            }        }        masterSqlSessionTemplate.update(getStatement(UPDATE_BY_ENTITY),paramMap);    }}