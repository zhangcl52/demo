package com.hunter.base.dao;import org.mybatis.spring.SqlSessionTemplate;import java.util.List;import java.util.Map;/** * @Author zhangcl * @Date 16/7/4  下午10:51 */public class MybatisBaseDao<T> implements IBaseDao {    private String nameSpace;    /**     * 暂不支持一主多从     */    private SqlSessionTemplate masterSqlSessionTemplate;    private SqlSessionTemplate slaveSqlSessionTemplate;    public MybatisBaseDao() {    }    public void setNameSpace(String nameSpace) {        this.nameSpace = nameSpace;    }    public void setMasterSqlSessionTemplate(SqlSessionTemplate masterSqlSessionTemplate) {        this.masterSqlSessionTemplate = masterSqlSessionTemplate;    }    public void setSlaveSqlSessionTemplate(SqlSessionTemplate slaveSqlSessionTemplate) {        this.slaveSqlSessionTemplate = slaveSqlSessionTemplate;    }//    private SqlSessionTemplate chooseDataSource() {//        if (TransactionContext.isInTransaction()) {//            return this.masterSqlSessionTemplate;//        }//        return this.slaveSqlSessionTemplate;//    }    public long countBySql(String sql, Map param) {        return 0;    }    public Object findOneById(long id) {        return null;    }    public Object findOneBySql(String sql, Map param) {        return null;    }    public List findListByIds(List ids) {        return null;    }    public List findListBySql(String sql, Map param) {        return null;    }    public int insert(Object entity) {        return 0;    }    public int updateBySql(String sql, Map param) {        return 0;    }    public int deleteById(long id) {        return 0;    }    public int deleteByIds(List ids) {        return 0;    }    public int deleteBySql(String sql, Map param) {        return 0;    }}