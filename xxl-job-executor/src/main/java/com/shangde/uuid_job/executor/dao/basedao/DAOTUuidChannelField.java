package com.shangde.uuid_job.executor.dao.basedao;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map;
import java.util.Set;
import com.shangde.uuid_job.executor.dto.basepo.ModelTUuidChannelField.ResultSetMapperModelTUuidChannelField;
import com.shawn.ss.lib.tools.CollectionHelper;
import com.shawn.ss.lib.tools.TypeConstantHelper;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.SimpleDbInterface;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.ColumnDataType;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.LogicalOpType;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.LogicalRelationshipType;
import com.shawn.ss.lib.tools.db.dto_base.model.AbstractBaseModel;
import com.shawn.ss.lib.tools.db.impl.dao.AbstractDao;
import com.shawn.ss.lib.tools.db.impl.dao.DaoInterface;
import com.shawn.ss.lib.tools.service_assemble.AbstractMultipleDaoAssembler;
import com.shawn.ss.lib.tools.service_assemble.BaseMultipleDaoAssembler;
import com.shawn.ss.lib.tools.service_assemble.DaoAssembler;
import com.shawn.ss.lib.tools.sql_code_gen.api.SQL;
import com.shawn.ss.lib.tools.sql_code_gen.api.SQLDelete;
import com.shawn.ss.lib.tools.sql_code_gen.api.SQLInsert;
import com.shawn.ss.lib.tools.sql_code_gen.api.SQLSelect;
import com.shawn.ss.lib.tools.sql_code_gen.api.SQLUpdate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.shangde.uuid_job.executor.dto.basepo.ModelTUuidChannelField;

@Repository("DAOTUuidChannelField")
@SuppressWarnings("unchecked")
public class DAOTUuidChannelField
    extends AbstractDao<com.shangde.uuid_job.executor.dto.basepo.ModelTUuidChannelField, Integer>
    implements DaoInterface<com.shangde.uuid_job.executor.dto.basepo.ModelTUuidChannelField, Integer> , InitializingBean
{
    public final static Logger logger = LoggerFactory.getLogger(DAOTUuidChannelField.class);
    @Autowired(required = true)
    @Qualifier("common_uuid")
    protected SimpleDbInterface data_store;

    public DAOTUuidChannelField() {
        super(com.shangde.uuid_job.executor.dto.basepo.ModelTUuidChannelField.class);
    }

    @Override
    public void afterPropertiesSet()
        throws Exception
    {
    }

    protected<TT> TT getSingleResult(DaoAssembler assembler, SQL<SQLSelect> sqlBuilder, Map<String, Object> param, Class<TT> tClass) {
        SimpleDbInterface dbInstance = data_store;
        return super.getSingleResult(dbInstance, assembler, sqlBuilder, param, tClass);
    }

    protected<TT> List<TT> getSingleResults(DaoAssembler assembler, SQL<SQLSelect> sqlBuilder, Map<String, Object> param, Class<TT> tClass) {
        SimpleDbInterface dbInstance = data_store;
        return super.getSingleResults(dbInstance, assembler, sqlBuilder, param, tClass);
    }

    protected List<ModelTUuidChannelField> getResults(DaoAssembler assembler, SQL<SQLSelect> sqlBuilder, Map<String, Object> param) {
        int status = 0;
        if (assembler!= null) {
            status = assembler.assembleSql(sqlBuilder, param, ModelTUuidChannelField.class);
        }
        SimpleDbInterface dbInstance = data_store;
        if (status == 0) {
            ResultSetMapperModelTUuidChannelField<ModelTUuidChannelField> rsMapper = ModelTUuidChannelField.RESULT_SET_OBJ_MAPPER;
            if (assembler!= null) {
                ResultSetMapperModelTUuidChannelField<ModelTUuidChannelField> rsMapperTmp = ((ResultSetMapperModelTUuidChannelField<ModelTUuidChannelField> ) assembler.<ModelTUuidChannelField> assembleResultSetMapper(param, ModelTUuidChannelField.class));
                if (rsMapperTmp!= null) {
                    rsMapper = rsMapperTmp;
                }
            }
            try {
                return super.getResults(dbInstance, assembler, sqlBuilder, param, rsMapper);
            } catch (final Exception ex) {
                logger.error("sql execption", ex);
                return null;
            }
        } else {
            return null;
        }
    }

    protected ModelTUuidChannelField getResult(DaoAssembler assembler, SQL<SQLSelect> sqlBuilder, Map<String, Object> param) {
        int status = 0;
        if (assembler!= null) {
            status = assembler.assembleSql(sqlBuilder, param, ModelTUuidChannelField.class);
        }
        SimpleDbInterface dbInstance = data_store;
        if (status == 0) {
            ResultSetMapperModelTUuidChannelField<ModelTUuidChannelField> rsMapper = ModelTUuidChannelField.RESULT_SET_OBJ_MAPPER;
            if (assembler!= null) {
                ResultSetMapperModelTUuidChannelField<ModelTUuidChannelField> rsMapperTmp = ((ResultSetMapperModelTUuidChannelField<ModelTUuidChannelField> ) assembler.<ModelTUuidChannelField> assembleResultSetMapper(param, ModelTUuidChannelField.class));
                if (rsMapperTmp!= null) {
                    rsMapper = rsMapperTmp;
                }
            }
            try {
                return super.getResult(dbInstance, assembler, sqlBuilder, param, rsMapper);
            } catch (final Exception ex) {
                logger.error("sql execption", ex);
                return null;
            }
        } else {
            return null;
        }
    }

    protected void buildInClause(SQLSelect sqlBuilder, String inField, Map<String, Object> param, List indexes) {
        if (ModelTUuidChannelField.FIELD_CLASS.containsKey(inField)) {
            Object fieldClassObj = ModelTUuidChannelField.FIELD_CLASS.get(inField);
            super.buildRawInCluase(sqlBuilder, param, inField, fieldClassObj, indexes);
        } else {
            logger.error("field parameter error");
            throw new IllegalArgumentException(((("there is mistake with infield parameter, column "+ inField)+" not found in table ")+ com.shangde.uuid_job.executor.dto.basepo.ModelTUuidChannelField.DTO_TABLE_NAME));
        }
    }

    protected void buildConditionCluase(SQLSelect<SQLSelect> sqlBuilder, ModelTUuidChannelField instance, Map<String, Object> param) {
        Integer dId = instance.getId();
        if (dId!= null) {
            sqlBuilder.where(ModelTUuidChannelField.FI_ID, ColumnDataType.intData);
            param.put(ModelTUuidChannelField.FI_ID, dId);
        }
        String dChannel_name = instance.getChannelName();
        if (dChannel_name!= null) {
            sqlBuilder.where(ModelTUuidChannelField.FI_CHANNEL_NAME, ColumnDataType.stringData);
            param.put(ModelTUuidChannelField.FI_CHANNEL_NAME, dChannel_name);
        }
        Byte dType_code = instance.getTypeCode();
        if (dType_code!= null) {
            sqlBuilder.where(ModelTUuidChannelField.FI_TYPE_CODE, ColumnDataType.byteData);
            param.put(ModelTUuidChannelField.FI_TYPE_CODE, dType_code);
        }
    }

    protected void buildSelectFieldCluase(SQLSelect<SQLSelect> sqlBuilder, Set<String> selectFields) {
        if (selectFields.contains(ModelTUuidChannelField.FI_ID)) {
            sqlBuilder.items(ModelTUuidChannelField.FI_ID);
        }
        if (selectFields.contains(ModelTUuidChannelField.FI_CHANNEL_NAME)) {
            sqlBuilder.items(ModelTUuidChannelField.FI_CHANNEL_NAME);
        }
        if (selectFields.contains(ModelTUuidChannelField.FI_TYPE_CODE)) {
            sqlBuilder.items(ModelTUuidChannelField.FI_TYPE_CODE);
        }
    }

    public List<ModelTUuidChannelField> get(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count) {
        if (selectFields == null) {
            selectFields = ModelTUuidChannelField.FIELD_CLASS.keySet();
        }
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTUuidChannelField.DTO_TABLE_NAME);
        if (start == null) {
            start = AbstractBaseModel.DEFAULT_START;
        }
        if (count == null) {
            count = AbstractBaseModel.DEFUALT_COUNT;
        }
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        sqlBuilder.setLimit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelTUuidChannelField> get(Set<String> selectFields, Integer start, Integer count) {
        return get(selectFields, null, start, count);
    }

    public List<ModelTUuidChannelField> get(Integer start, Integer count) {
        return get(null, start, count);
    }

    public List<ModelTUuidChannelField> get() {
        return get(null, null);
    }

    public List<ModelTUuidChannelField> getById(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, List<Integer> id) {
        if (selectFields == null) {
            selectFields = ModelTUuidChannelField.FIELD_CLASS.keySet();
        }
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTUuidChannelField.DTO_TABLE_NAME);
        if (start == null) {
            start = AbstractBaseModel.DEFAULT_START;
        }
        if (count == null) {
            count = AbstractBaseModel.DEFUALT_COUNT;
        }
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        if (id!= null) {
            sqlBuilder.where(LogicalRelationshipType.and, LogicalOpType.in, null, ModelTUuidChannelField.FI_ID, ModelTUuidChannelField.FI_ID, ColumnDataType.intData);
            param.put(ModelTUuidChannelField.FI_ID, id);
        }
        sqlBuilder.setLimit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelTUuidChannelField> getById(Set<String> selectFields, Integer start, Integer count, List<Integer> id) {
        return getById(selectFields, null, start, count, id);
    }

    public List<ModelTUuidChannelField> getById(Integer start, Integer count, List<Integer> id) {
        return getById(null, start, count, id);
    }

    public List<ModelTUuidChannelField> getById(List<Integer> id) {
        return getById(null, null, id);
    }

    public List<ModelTUuidChannelField> getByIndex(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, String inField, List indexes) {
        if (selectFields == null) {
            selectFields = ModelTUuidChannelField.FIELD_CLASS.keySet();
        }
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTUuidChannelField.DTO_TABLE_NAME);
        if (start == null) {
            start = AbstractBaseModel.DEFAULT_START;
        }
        if (count == null) {
            count = AbstractBaseModel.DEFUALT_COUNT;
        }
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        buildInClause(sqlBuilder, inField, param, indexes);
        sqlBuilder.setLimit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelTUuidChannelField> getByIndex(Set<String> selectFields, Integer start, Integer count, String inField, List indexes) {
        return getByIndex(selectFields, null, start, count, inField, indexes);
    }

    public List<ModelTUuidChannelField> getByIndex(Integer start, Integer count, String inField, List indexes) {
        return getByIndex(null, start, count, inField, indexes);
    }

    public List<ModelTUuidChannelField> getByIndex(String inField, List indexes) {
        return getByIndex(null, null, inField, indexes);
    }

    public List<ModelTUuidChannelField> getByCond(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelTUuidChannelField instance) {
        if (selectFields == null) {
            selectFields = ModelTUuidChannelField.FIELD_CLASS.keySet();
        }
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTUuidChannelField.DTO_TABLE_NAME);
        if (start == null) {
            start = AbstractBaseModel.DEFAULT_START;
        }
        if (count == null) {
            count = AbstractBaseModel.DEFUALT_COUNT;
        }
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        buildConditionCluase(sqlBuilder, instance, param);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        sqlBuilder.setLimit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelTUuidChannelField> getByCond(Set<String> selectFields, Integer start, Integer count, ModelTUuidChannelField instance) {
        return getByCond(selectFields, null, start, count, instance);
    }

    public List<ModelTUuidChannelField> getByCond(Integer start, Integer count, ModelTUuidChannelField instance) {
        return getByCond(null, start, count, instance);
    }

    public List<ModelTUuidChannelField> getByCond(ModelTUuidChannelField instance) {
        return getByCond(null, null, instance);
    }

    public List<ModelTUuidChannelField> getByWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelTUuidChannelField.FIELD_CLASS.keySet();
        }
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTUuidChannelField.DTO_TABLE_NAME);
        if (start == null) {
            start = AbstractBaseModel.DEFAULT_START;
        }
        if (count == null) {
            count = AbstractBaseModel.DEFUALT_COUNT;
        }
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        super.buildRawWhere(sqlBuilder, param, extParam, extCondition);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        sqlBuilder.setLimit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelTUuidChannelField> getByWhere(Set<String> selectFields, Integer start, Integer count, Map<String, Object> extParam, Set<String> extCondition) {
        return getByWhere(selectFields, null, start, count, extParam, extCondition);
    }

    public List<ModelTUuidChannelField> getByWhere(Integer start, Integer count, Map<String, Object> extParam, Set<String> extCondition) {
        return getByWhere(null, start, count, extParam, extCondition);
    }

    public List<ModelTUuidChannelField> getByWhere(Map<String, Object> extParam, Set<String> extCondition) {
        return getByWhere(null, null, extParam, extCondition);
    }

    public List<ModelTUuidChannelField> getByCondAndIndex(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelTUuidChannelField instance, String inField, List indexes) {
        if (selectFields == null) {
            selectFields = ModelTUuidChannelField.FIELD_CLASS.keySet();
        }
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTUuidChannelField.DTO_TABLE_NAME);
        if (start == null) {
            start = AbstractBaseModel.DEFAULT_START;
        }
        if (count == null) {
            count = AbstractBaseModel.DEFUALT_COUNT;
        }
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        buildConditionCluase(sqlBuilder, instance, param);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        buildInClause(sqlBuilder, inField, param, indexes);
        sqlBuilder.setLimit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelTUuidChannelField> getByCondAndIndex(Set<String> selectFields, Integer start, Integer count, ModelTUuidChannelField instance, String inField, List indexes) {
        return getByCondAndIndex(selectFields, null, start, count, instance, inField, indexes);
    }

    public List<ModelTUuidChannelField> getByCondAndIndex(Integer start, Integer count, ModelTUuidChannelField instance, String inField, List indexes) {
        return getByCondAndIndex(null, start, count, instance, inField, indexes);
    }

    public List<ModelTUuidChannelField> getByCondAndIndex(ModelTUuidChannelField instance, String inField, List indexes) {
        return getByCondAndIndex(null, null, instance, inField, indexes);
    }

    public List<ModelTUuidChannelField> getByIdAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelTUuidChannelField.FIELD_CLASS.keySet();
        }
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTUuidChannelField.DTO_TABLE_NAME);
        if (start == null) {
            start = AbstractBaseModel.DEFAULT_START;
        }
        if (count == null) {
            count = AbstractBaseModel.DEFUALT_COUNT;
        }
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        super.buildRawWhere(sqlBuilder, param, extParam, extCondition);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        if (id!= null) {
            sqlBuilder.where(LogicalRelationshipType.and, LogicalOpType.in, null, ModelTUuidChannelField.FI_ID, ModelTUuidChannelField.FI_ID, ColumnDataType.intData);
            param.put(ModelTUuidChannelField.FI_ID, id);
        }
        sqlBuilder.setLimit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelTUuidChannelField> getByIdAndWhere(Set<String> selectFields, Integer start, Integer count, Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndWhere(selectFields, null, start, count, id, extParam, extCondition);
    }

    public List<ModelTUuidChannelField> getByIdAndWhere(Integer start, Integer count, Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndWhere(null, start, count, id, extParam, extCondition);
    }

    public List<ModelTUuidChannelField> getByIdAndWhere(Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndWhere(null, null, id, extParam, extCondition);
    }

    public List<ModelTUuidChannelField> getByIdAndCondAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelTUuidChannelField instance, List<Integer> id, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelTUuidChannelField.FIELD_CLASS.keySet();
        }
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTUuidChannelField.DTO_TABLE_NAME);
        if (start == null) {
            start = AbstractBaseModel.DEFAULT_START;
        }
        if (count == null) {
            count = AbstractBaseModel.DEFUALT_COUNT;
        }
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        super.buildRawWhere(sqlBuilder, param, extParam, extCondition);
        buildConditionCluase(sqlBuilder, instance, param);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        if (id!= null) {
            sqlBuilder.where(LogicalRelationshipType.and, LogicalOpType.in, null, ModelTUuidChannelField.FI_ID, ModelTUuidChannelField.FI_ID, ColumnDataType.intData);
            param.put(ModelTUuidChannelField.FI_ID, id);
        }
        sqlBuilder.setLimit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelTUuidChannelField> getByIdAndCondAndWhere(Set<String> selectFields, Integer start, Integer count, ModelTUuidChannelField instance, List<Integer> id, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndCondAndWhere(selectFields, null, start, count, instance, id, extParam, extCondition);
    }

    public List<ModelTUuidChannelField> getByIdAndCondAndWhere(Integer start, Integer count, ModelTUuidChannelField instance, List<Integer> id, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndCondAndWhere(null, start, count, instance, id, extParam, extCondition);
    }

    public List<ModelTUuidChannelField> getByIdAndCondAndWhere(ModelTUuidChannelField instance, List<Integer> id, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndCondAndWhere(null, null, instance, id, extParam, extCondition);
    }

    public List<ModelTUuidChannelField> getByIndexAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelTUuidChannelField.FIELD_CLASS.keySet();
        }
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTUuidChannelField.DTO_TABLE_NAME);
        if (start == null) {
            start = AbstractBaseModel.DEFAULT_START;
        }
        if (count == null) {
            count = AbstractBaseModel.DEFUALT_COUNT;
        }
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        super.buildRawWhere(sqlBuilder, param, extParam, extCondition);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        buildInClause(sqlBuilder, inField, param, indexes);
        sqlBuilder.setLimit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelTUuidChannelField> getByIndexAndWhere(Set<String> selectFields, Integer start, Integer count, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIndexAndWhere(selectFields, null, start, count, inField, indexes, extParam, extCondition);
    }

    public List<ModelTUuidChannelField> getByIndexAndWhere(Integer start, Integer count, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIndexAndWhere(null, start, count, inField, indexes, extParam, extCondition);
    }

    public List<ModelTUuidChannelField> getByIndexAndWhere(String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIndexAndWhere(null, null, inField, indexes, extParam, extCondition);
    }

    public List<ModelTUuidChannelField> getByCondAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelTUuidChannelField instance, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelTUuidChannelField.FIELD_CLASS.keySet();
        }
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTUuidChannelField.DTO_TABLE_NAME);
        if (start == null) {
            start = AbstractBaseModel.DEFAULT_START;
        }
        if (count == null) {
            count = AbstractBaseModel.DEFUALT_COUNT;
        }
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        super.buildRawWhere(sqlBuilder, param, extParam, extCondition);
        buildConditionCluase(sqlBuilder, instance, param);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        sqlBuilder.setLimit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelTUuidChannelField> getByCondAndWhere(Set<String> selectFields, Integer start, Integer count, ModelTUuidChannelField instance, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndWhere(selectFields, null, start, count, instance, extParam, extCondition);
    }

    public List<ModelTUuidChannelField> getByCondAndWhere(Integer start, Integer count, ModelTUuidChannelField instance, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndWhere(null, start, count, instance, extParam, extCondition);
    }

    public List<ModelTUuidChannelField> getByCondAndWhere(ModelTUuidChannelField instance, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndWhere(null, null, instance, extParam, extCondition);
    }

    public List<ModelTUuidChannelField> getByCondAndIndexAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelTUuidChannelField instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelTUuidChannelField.FIELD_CLASS.keySet();
        }
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTUuidChannelField.DTO_TABLE_NAME);
        if (start == null) {
            start = AbstractBaseModel.DEFAULT_START;
        }
        if (count == null) {
            count = AbstractBaseModel.DEFUALT_COUNT;
        }
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        super.buildRawWhere(sqlBuilder, param, extParam, extCondition);
        buildConditionCluase(sqlBuilder, instance, param);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        buildInClause(sqlBuilder, inField, param, indexes);
        sqlBuilder.setLimit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelTUuidChannelField> getByCondAndIndexAndWhere(Set<String> selectFields, Integer start, Integer count, ModelTUuidChannelField instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndIndexAndWhere(selectFields, null, start, count, instance, inField, indexes, extParam, extCondition);
    }

    public List<ModelTUuidChannelField> getByCondAndIndexAndWhere(Integer start, Integer count, ModelTUuidChannelField instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndIndexAndWhere(null, start, count, instance, inField, indexes, extParam, extCondition);
    }

    public List<ModelTUuidChannelField> getByCondAndIndexAndWhere(ModelTUuidChannelField instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndIndexAndWhere(null, null, instance, inField, indexes, extParam, extCondition);
    }

    public ModelTUuidChannelField getOneById(Set<String> selectFields, DaoAssembler assembler, Integer id) {
        if (selectFields == null) {
            selectFields = ModelTUuidChannelField.FIELD_CLASS.keySet();
        }
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTUuidChannelField.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        if (id!= null) {
            sqlBuilder.where(ModelTUuidChannelField.FI_ID, ColumnDataType.intData);
            param.put(ModelTUuidChannelField.FI_ID, id);
        }
        sqlBuilder.setLimit();
        return getResult(assembler, sqlBuilder, param);
    }

    public ModelTUuidChannelField getOneById(Set<String> selectFields, Integer id) {
        return getOneById(selectFields, null, id);
    }

    public ModelTUuidChannelField getOneById(Integer id) {
        return getOneById(null, id);
    }

    public ModelTUuidChannelField getOneByCond(Set<String> selectFields, DaoAssembler assembler, ModelTUuidChannelField instance) {
        if (selectFields == null) {
            selectFields = ModelTUuidChannelField.FIELD_CLASS.keySet();
        }
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTUuidChannelField.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        buildConditionCluase(sqlBuilder, instance, param);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        sqlBuilder.setLimit();
        return getResult(assembler, sqlBuilder, param);
    }

    public ModelTUuidChannelField getOneByCond(Set<String> selectFields, ModelTUuidChannelField instance) {
        return getOneByCond(selectFields, null, instance);
    }

    public ModelTUuidChannelField getOneByCond(ModelTUuidChannelField instance) {
        return getOneByCond(null, instance);
    }

    public ModelTUuidChannelField getOneByWhere(Set<String> selectFields, DaoAssembler assembler, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelTUuidChannelField.FIELD_CLASS.keySet();
        }
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTUuidChannelField.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        super.buildRawWhere(sqlBuilder, param, extParam, extCondition);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        sqlBuilder.setLimit();
        return getResult(assembler, sqlBuilder, param);
    }

    public ModelTUuidChannelField getOneByWhere(Set<String> selectFields, Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByWhere(selectFields, null, extParam, extCondition);
    }

    public ModelTUuidChannelField getOneByWhere(Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByWhere(null, extParam, extCondition);
    }

    public ModelTUuidChannelField getOneByCondAndWhere(Set<String> selectFields, DaoAssembler assembler, ModelTUuidChannelField instance, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelTUuidChannelField.FIELD_CLASS.keySet();
        }
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTUuidChannelField.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        super.buildRawWhere(sqlBuilder, param, extParam, extCondition);
        buildConditionCluase(sqlBuilder, instance, param);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        sqlBuilder.setLimit();
        return getResult(assembler, sqlBuilder, param);
    }

    public ModelTUuidChannelField getOneByCondAndWhere(Set<String> selectFields, ModelTUuidChannelField instance, Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByCondAndWhere(selectFields, null, instance, extParam, extCondition);
    }

    public ModelTUuidChannelField getOneByCondAndWhere(ModelTUuidChannelField instance, Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByCondAndWhere(null, instance, extParam, extCondition);
    }

    public ModelTUuidChannelField getOneByIdAndCondAndWhere(Set<String> selectFields, DaoAssembler assembler, ModelTUuidChannelField instance, Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelTUuidChannelField.FIELD_CLASS.keySet();
        }
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTUuidChannelField.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        super.buildRawWhere(sqlBuilder, param, extParam, extCondition);
        buildConditionCluase(sqlBuilder, instance, param);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        if (id!= null) {
            sqlBuilder.where(ModelTUuidChannelField.FI_ID, ColumnDataType.intData);
            param.put(ModelTUuidChannelField.FI_ID, id);
        }
        sqlBuilder.setLimit();
        return getResult(assembler, sqlBuilder, param);
    }

    public ModelTUuidChannelField getOneByIdAndCondAndWhere(Set<String> selectFields, ModelTUuidChannelField instance, Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByIdAndCondAndWhere(selectFields, null, instance, id, extParam, extCondition);
    }

    public ModelTUuidChannelField getOneByIdAndCondAndWhere(ModelTUuidChannelField instance, Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByIdAndCondAndWhere(null, instance, id, extParam, extCondition);
    }

    public Long getCountByCond(DaoAssembler assembler, ModelTUuidChannelField instance) {
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTUuidChannelField.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        sqlBuilder.funcItems("count", "count");
        buildConditionCluase(sqlBuilder, instance, param);
        sqlBuilder.setLimit();
        return getSingleResult(assembler, sqlBuilder, param, Long.class);
    }

    public Long getCountByCond(ModelTUuidChannelField instance) {
        return getCountByCond(null, instance);
    }

    public Long getCountByCondAndIndex(DaoAssembler assembler, ModelTUuidChannelField instance, String inField, List indexes) {
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTUuidChannelField.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        sqlBuilder.funcItems("count", "count");
        buildConditionCluase(sqlBuilder, instance, param);
        buildInClause(sqlBuilder, inField, param, indexes);
        sqlBuilder.setLimit();
        return getSingleResult(assembler, sqlBuilder, param, Long.class);
    }

    public Long getCountByCondAndIndex(ModelTUuidChannelField instance, String inField, List indexes) {
        return getCountByCondAndIndex(null, instance, inField, indexes);
    }

    public Long getCountByCondAndIndexAndWhere(DaoAssembler assembler, ModelTUuidChannelField instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTUuidChannelField.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        super.buildRawWhere(sqlBuilder, param, extParam, extCondition);
        sqlBuilder.funcItems("count", "count");
        buildConditionCluase(sqlBuilder, instance, param);
        buildInClause(sqlBuilder, inField, param, indexes);
        sqlBuilder.setLimit();
        return getSingleResult(assembler, sqlBuilder, param, Long.class);
    }

    public Long getCountByCondAndIndexAndWhere(ModelTUuidChannelField instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getCountByCondAndIndexAndWhere(null, instance, inField, indexes, extParam, extCondition);
    }

    public<TT> TT getItemByIndex(DaoAssembler assembler, String inField, List indexes, Class<TT> tClass, String rawItem) {
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTUuidChannelField.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        assert((tClass!= null));
        assert(((rawItem!= null)&&(rawItem.length()> 0)));
        sqlBuilder.rawItem(rawItem);
        buildInClause(sqlBuilder, inField, param, indexes);
        sqlBuilder.setLimit();
        return ((TT) getSingleResult(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> TT getItemByIndex(String inField, List indexes, Class<TT> tClass, String rawItem) {
        return getItemByIndex(null, inField, indexes, tClass, rawItem);
    }

    public<TT> TT getItemByWhere(DaoAssembler assembler, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTUuidChannelField.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        super.buildRawWhere(sqlBuilder, param, extParam, extCondition);
        assert((tClass!= null));
        assert(((rawItem!= null)&&(rawItem.length()> 0)));
        sqlBuilder.rawItem(rawItem);
        sqlBuilder.setLimit();
        return ((TT) getSingleResult(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> TT getItemByWhere(Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemByWhere(null, tClass, rawItem, extParam, extCondition);
    }

    public<TT> TT getItemByCond(DaoAssembler assembler, ModelTUuidChannelField instance, Class<TT> tClass, String rawItem) {
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTUuidChannelField.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        assert((tClass!= null));
        assert(((rawItem!= null)&&(rawItem.length()> 0)));
        sqlBuilder.rawItem(rawItem);
        buildConditionCluase(sqlBuilder, instance, param);
        sqlBuilder.setLimit();
        return ((TT) getSingleResult(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> TT getItemByCond(ModelTUuidChannelField instance, Class<TT> tClass, String rawItem) {
        return getItemByCond(null, instance, tClass, rawItem);
    }

    public<TT> TT getItemByCondAndIndex(DaoAssembler assembler, ModelTUuidChannelField instance, String inField, List indexes, Class<TT> tClass, String rawItem) {
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTUuidChannelField.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        assert((tClass!= null));
        assert(((rawItem!= null)&&(rawItem.length()> 0)));
        sqlBuilder.rawItem(rawItem);
        buildConditionCluase(sqlBuilder, instance, param);
        buildInClause(sqlBuilder, inField, param, indexes);
        sqlBuilder.setLimit();
        return ((TT) getSingleResult(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> TT getItemByCondAndIndex(ModelTUuidChannelField instance, String inField, List indexes, Class<TT> tClass, String rawItem) {
        return getItemByCondAndIndex(null, instance, inField, indexes, tClass, rawItem);
    }

    public<TT> TT getItemByCondAndIndexAndWhere(DaoAssembler assembler, ModelTUuidChannelField instance, String inField, List indexes, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTUuidChannelField.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        super.buildRawWhere(sqlBuilder, param, extParam, extCondition);
        assert((tClass!= null));
        assert(((rawItem!= null)&&(rawItem.length()> 0)));
        sqlBuilder.rawItem(rawItem);
        buildConditionCluase(sqlBuilder, instance, param);
        buildInClause(sqlBuilder, inField, param, indexes);
        sqlBuilder.setLimit();
        return ((TT) getSingleResult(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> TT getItemByCondAndIndexAndWhere(ModelTUuidChannelField instance, String inField, List indexes, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemByCondAndIndexAndWhere(null, instance, inField, indexes, tClass, rawItem, extParam, extCondition);
    }

    public<TT> List<TT> getItemListByIndex(DaoAssembler assembler, Integer start, Integer count, String inField, List indexes, Class<TT> tClass, String rawItem) {
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTUuidChannelField.DTO_TABLE_NAME);
        if (start == null) {
            start = AbstractBaseModel.DEFAULT_START;
        }
        if (count == null) {
            count = AbstractBaseModel.DEFUALT_COUNT;
        }
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        assert((tClass!= null));
        assert(((rawItem!= null)&&(rawItem.length()> 0)));
        sqlBuilder.rawItem(rawItem);
        buildInClause(sqlBuilder, inField, param, indexes);
        sqlBuilder.setLimit();
        return ((List<TT> ) getSingleResults(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> List<TT> getItemListByIndex(Integer start, Integer count, String inField, List indexes, Class<TT> tClass, String rawItem) {
        return getItemListByIndex(null, start, count, inField, indexes, tClass, rawItem);
    }

    public<TT extends Object> List<TT> getItemListByIndex(String inField, List indexes, Class<TT> tClass, String rawItem) {
        return getItemListByIndex(null, null, inField, indexes, tClass, rawItem);
    }

    public<TT> List<TT> getItemListByCond(DaoAssembler assembler, Integer start, Integer count, ModelTUuidChannelField instance, Class<TT> tClass, String rawItem) {
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTUuidChannelField.DTO_TABLE_NAME);
        if (start == null) {
            start = AbstractBaseModel.DEFAULT_START;
        }
        if (count == null) {
            count = AbstractBaseModel.DEFUALT_COUNT;
        }
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        assert((tClass!= null));
        assert(((rawItem!= null)&&(rawItem.length()> 0)));
        sqlBuilder.rawItem(rawItem);
        buildConditionCluase(sqlBuilder, instance, param);
        sqlBuilder.setLimit();
        return ((List<TT> ) getSingleResults(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> List<TT> getItemListByCond(Integer start, Integer count, ModelTUuidChannelField instance, Class<TT> tClass, String rawItem) {
        return getItemListByCond(null, start, count, instance, tClass, rawItem);
    }

    public<TT extends Object> List<TT> getItemListByCond(ModelTUuidChannelField instance, Class<TT> tClass, String rawItem) {
        return getItemListByCond(null, null, instance, tClass, rawItem);
    }

    public<TT> List<TT> getItemListById(DaoAssembler assembler, Integer start, Integer count, Integer id, Class<TT> tClass, String rawItem) {
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTUuidChannelField.DTO_TABLE_NAME);
        if (start == null) {
            start = AbstractBaseModel.DEFAULT_START;
        }
        if (count == null) {
            count = AbstractBaseModel.DEFUALT_COUNT;
        }
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        assert((tClass!= null));
        assert(((rawItem!= null)&&(rawItem.length()> 0)));
        sqlBuilder.rawItem(rawItem);
        if (id!= null) {
            sqlBuilder.where(LogicalRelationshipType.and, LogicalOpType.in, null, ModelTUuidChannelField.FI_ID, ModelTUuidChannelField.FI_ID, ColumnDataType.intData);
            param.put(ModelTUuidChannelField.FI_ID, id);
        }
        sqlBuilder.setLimit();
        return ((List<TT> ) getSingleResults(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> List<TT> getItemListById(Integer start, Integer count, Integer id, Class<TT> tClass, String rawItem) {
        return getItemListById(null, start, count, id, tClass, rawItem);
    }

    public<TT extends Object> List<TT> getItemListById(Integer id, Class<TT> tClass, String rawItem) {
        return getItemListById(null, null, id, tClass, rawItem);
    }

    public<TT> List<TT> getItemListByWhere(DaoAssembler assembler, Integer start, Integer count, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTUuidChannelField.DTO_TABLE_NAME);
        if (start == null) {
            start = AbstractBaseModel.DEFAULT_START;
        }
        if (count == null) {
            count = AbstractBaseModel.DEFUALT_COUNT;
        }
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        super.buildRawWhere(sqlBuilder, param, extParam, extCondition);
        assert((tClass!= null));
        assert(((rawItem!= null)&&(rawItem.length()> 0)));
        sqlBuilder.rawItem(rawItem);
        sqlBuilder.setLimit();
        return ((List<TT> ) getSingleResults(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> List<TT> getItemListByWhere(Integer start, Integer count, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByWhere(null, start, count, tClass, rawItem, extParam, extCondition);
    }

    public<TT extends Object> List<TT> getItemListByWhere(Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByWhere(null, null, tClass, rawItem, extParam, extCondition);
    }

    public<TT> List<TT> getItemListByIndexAndWhere(DaoAssembler assembler, Integer start, Integer count, String inField, List indexes, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTUuidChannelField.DTO_TABLE_NAME);
        if (start == null) {
            start = AbstractBaseModel.DEFAULT_START;
        }
        if (count == null) {
            count = AbstractBaseModel.DEFUALT_COUNT;
        }
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        super.buildRawWhere(sqlBuilder, param, extParam, extCondition);
        assert((tClass!= null));
        assert(((rawItem!= null)&&(rawItem.length()> 0)));
        sqlBuilder.rawItem(rawItem);
        buildInClause(sqlBuilder, inField, param, indexes);
        sqlBuilder.setLimit();
        return ((List<TT> ) getSingleResults(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> List<TT> getItemListByIndexAndWhere(Integer start, Integer count, String inField, List indexes, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByIndexAndWhere(null, start, count, inField, indexes, tClass, rawItem, extParam, extCondition);
    }

    public<TT extends Object> List<TT> getItemListByIndexAndWhere(String inField, List indexes, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByIndexAndWhere(null, null, inField, indexes, tClass, rawItem, extParam, extCondition);
    }

    public<TT> List<TT> getItemListByCondAndWhere(DaoAssembler assembler, Integer start, Integer count, ModelTUuidChannelField instance, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTUuidChannelField.DTO_TABLE_NAME);
        if (start == null) {
            start = AbstractBaseModel.DEFAULT_START;
        }
        if (count == null) {
            count = AbstractBaseModel.DEFUALT_COUNT;
        }
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        super.buildRawWhere(sqlBuilder, param, extParam, extCondition);
        assert((tClass!= null));
        assert(((rawItem!= null)&&(rawItem.length()> 0)));
        sqlBuilder.rawItem(rawItem);
        buildConditionCluase(sqlBuilder, instance, param);
        sqlBuilder.setLimit();
        return ((List<TT> ) getSingleResults(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> List<TT> getItemListByCondAndWhere(Integer start, Integer count, ModelTUuidChannelField instance, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByCondAndWhere(null, start, count, instance, tClass, rawItem, extParam, extCondition);
    }

    public<TT extends Object> List<TT> getItemListByCondAndWhere(ModelTUuidChannelField instance, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByCondAndWhere(null, null, instance, tClass, rawItem, extParam, extCondition);
    }

    public<TT> List<TT> getItemListByCondAndIndex(DaoAssembler assembler, Integer start, Integer count, ModelTUuidChannelField instance, String inField, List indexes, Class<TT> tClass, String rawItem) {
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTUuidChannelField.DTO_TABLE_NAME);
        if (start == null) {
            start = AbstractBaseModel.DEFAULT_START;
        }
        if (count == null) {
            count = AbstractBaseModel.DEFUALT_COUNT;
        }
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        assert((tClass!= null));
        assert(((rawItem!= null)&&(rawItem.length()> 0)));
        sqlBuilder.rawItem(rawItem);
        buildConditionCluase(sqlBuilder, instance, param);
        buildInClause(sqlBuilder, inField, param, indexes);
        sqlBuilder.setLimit();
        return ((List<TT> ) getSingleResults(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> List<TT> getItemListByCondAndIndex(Integer start, Integer count, ModelTUuidChannelField instance, String inField, List indexes, Class<TT> tClass, String rawItem) {
        return getItemListByCondAndIndex(null, start, count, instance, inField, indexes, tClass, rawItem);
    }

    public<TT extends Object> List<TT> getItemListByCondAndIndex(ModelTUuidChannelField instance, String inField, List indexes, Class<TT> tClass, String rawItem) {
        return getItemListByCondAndIndex(null, null, instance, inField, indexes, tClass, rawItem);
    }

    public<TT> List<TT> getItemListByIdAndCondAndWhere(DaoAssembler assembler, Integer start, Integer count, ModelTUuidChannelField instance, List<Integer> id, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTUuidChannelField.DTO_TABLE_NAME);
        if (start == null) {
            start = AbstractBaseModel.DEFAULT_START;
        }
        if (count == null) {
            count = AbstractBaseModel.DEFUALT_COUNT;
        }
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        super.buildRawWhere(sqlBuilder, param, extParam, extCondition);
        assert((tClass!= null));
        assert(((rawItem!= null)&&(rawItem.length()> 0)));
        sqlBuilder.rawItem(rawItem);
        buildConditionCluase(sqlBuilder, instance, param);
        if (id!= null) {
            sqlBuilder.where(LogicalRelationshipType.and, LogicalOpType.in, null, ModelTUuidChannelField.FI_ID, ModelTUuidChannelField.FI_ID, ColumnDataType.intData);
            param.put(ModelTUuidChannelField.FI_ID, id);
        }
        sqlBuilder.setLimit();
        return ((List<TT> ) getSingleResults(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> List<TT> getItemListByIdAndCondAndWhere(Integer start, Integer count, ModelTUuidChannelField instance, List<Integer> id, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByIdAndCondAndWhere(null, start, count, instance, id, tClass, rawItem, extParam, extCondition);
    }

    public<TT extends Object> List<TT> getItemListByIdAndCondAndWhere(ModelTUuidChannelField instance, List<Integer> id, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByIdAndCondAndWhere(null, null, instance, id, tClass, rawItem, extParam, extCondition);
    }

    public ModelTUuidChannelField insert(ModelTUuidChannelField instance, DaoAssembler assembler) {
        SQLInsert sqlBuilder = SQL.buildInsertSql(ModelTUuidChannelField.DTO_TABLE_NAME);
        Integer dId = instance.getId();
        if (dId!= null) {
            sqlBuilder.items(ModelTUuidChannelField.FI_ID);
        }
        String dChannel_name = instance.getChannelName();
        if (dChannel_name!= null) {
            sqlBuilder.items(ModelTUuidChannelField.FI_CHANNEL_NAME);
        }
        Byte dType_code = instance.getTypeCode();
        if (dType_code!= null) {
            sqlBuilder.items(ModelTUuidChannelField.FI_TYPE_CODE);
        }
        Map<String, Object> param = ModelTUuidChannelField.MAP_OBJ_MAPPER.toCommonMap(instance);
        SimpleDbInterface dbInstance = data_store;
        Long ret = super.insert(dbInstance, assembler, sqlBuilder, param);
        if (ret!= null) {
            if (ret >Long.MIN_VALUE) {
                instance.setId(((Integer) TypeConstantHelper.testPackPrType(ret, Integer.class)));
                return instance;
            } else {
                return instance;
            }
        } else {
            return null;
        }
    }

    public ModelTUuidChannelField insert(ModelTUuidChannelField instance) {
        return insert(instance, null);
    }

    public Integer insert(List<ModelTUuidChannelField> instances, Set<String> fields, DaoAssembler assembler) {
        if (fields == null) {
            fields = ModelTUuidChannelField.FIELD_CLASS.keySet();
        }
        SQLInsert sqlBuilder = SQL.buildInsertSql(ModelTUuidChannelField.DTO_TABLE_NAME);
        if (fields.contains(ModelTUuidChannelField.FI_ID)) {
            sqlBuilder.items(ModelTUuidChannelField.FI_ID);
        }
        if (fields.contains(ModelTUuidChannelField.FI_CHANNEL_NAME)) {
            sqlBuilder.items(ModelTUuidChannelField.FI_CHANNEL_NAME);
        }
        if (fields.contains(ModelTUuidChannelField.FI_TYPE_CODE)) {
            sqlBuilder.items(ModelTUuidChannelField.FI_TYPE_CODE);
        }
        List<Map<String, Object>> param = CollectionHelper.<Map<String,Object>> newList();
        for (ModelTUuidChannelField instance: instances) {
            Map<String, Object> paramMap = ModelTUuidChannelField.MAP_OBJ_MAPPER.toCommonMap(instance);
            param.add(paramMap);
        }
        SimpleDbInterface dbInstance = data_store;
        return super.batchInsert(dbInstance, assembler, sqlBuilder, param);
    }

    public Integer insert(List<ModelTUuidChannelField> instances, Set<String> fields) {
        return insert(instances, fields, null);
    }

    public Integer insert(List<ModelTUuidChannelField> instances) {
        return insert(instances, null, null);
    }

    public Integer update(ModelTUuidChannelField instance, Set<String> conditionField, DaoAssembler assembler) {
        SQLUpdate sqlBuilder = SQL.buildUpdateSql(ModelTUuidChannelField.DTO_TABLE_NAME);
        Integer dId = instance.getId();
        if (conditionField.contains(ModelTUuidChannelField.FI_ID)) {
            assert((dId!= null));
            sqlBuilder.where(ModelTUuidChannelField.FI_ID, ColumnDataType.intData);
        } else {
            if (dId!= null) {
                sqlBuilder.items(ModelTUuidChannelField.FI_ID);
            }
        }
        String dChannel_name = instance.getChannelName();
        if (conditionField.contains(ModelTUuidChannelField.FI_CHANNEL_NAME)) {
            assert((dChannel_name!= null));
            sqlBuilder.where(ModelTUuidChannelField.FI_CHANNEL_NAME, ColumnDataType.stringData);
        } else {
            if (dChannel_name!= null) {
                sqlBuilder.items(ModelTUuidChannelField.FI_CHANNEL_NAME);
            }
        }
        Byte dType_code = instance.getTypeCode();
        if (conditionField.contains(ModelTUuidChannelField.FI_TYPE_CODE)) {
            assert((dType_code!= null));
            sqlBuilder.where(ModelTUuidChannelField.FI_TYPE_CODE, ColumnDataType.byteData);
        } else {
            if (dType_code!= null) {
                sqlBuilder.items(ModelTUuidChannelField.FI_TYPE_CODE);
            }
        }
        Map<String, Object> param = ModelTUuidChannelField.MAP_OBJ_MAPPER.toCommonMap(instance);
        SimpleDbInterface dbInstance = data_store;
        return super.update(dbInstance, assembler, sqlBuilder, param);
    }

    public Integer update(ModelTUuidChannelField instance, Set<String> conditionField) {
        return update(instance, conditionField, null);
    }

    public Integer updateById(ModelTUuidChannelField instance, DaoAssembler assembler) {
        SQLUpdate sqlBuilder = SQL.buildUpdateSql(ModelTUuidChannelField.DTO_TABLE_NAME);
        assert((instance.getId()!= null));
        Integer dId = instance.getId();
        if (dId!= null) {
            sqlBuilder.where(ModelTUuidChannelField.FI_ID, ColumnDataType.intData);
        }
        String dChannel_name = instance.getChannelName();
        if (dChannel_name!= null) {
            sqlBuilder.items(ModelTUuidChannelField.FI_CHANNEL_NAME);
        }
        Byte dType_code = instance.getTypeCode();
        if (dType_code!= null) {
            sqlBuilder.items(ModelTUuidChannelField.FI_TYPE_CODE);
        }
        Map<String, Object> param = ModelTUuidChannelField.MAP_OBJ_MAPPER.toCommonMap(instance);
        SimpleDbInterface dbInstance = data_store;
        return super.update(dbInstance, assembler, sqlBuilder, param);
    }

    public Integer updateById(ModelTUuidChannelField instance) {
        return updateById(instance, null);
    }

    public Integer updateByIds(ModelTUuidChannelField instance, Set<Integer> ids, DaoAssembler assembler) {
        SQLUpdate sqlBuilder = SQL.buildUpdateSql(ModelTUuidChannelField.DTO_TABLE_NAME);
        assert(((ids!= null)&&(ids.size()> 0)));
        sqlBuilder.where(LogicalOpType.in, ModelTUuidChannelField.FI_ID, "ids", ColumnDataType.intData);
        instance.setId(null);
        String dChannel_name = instance.getChannelName();
        if (dChannel_name!= null) {
            sqlBuilder.items(ModelTUuidChannelField.FI_CHANNEL_NAME);
        }
        Byte dType_code = instance.getTypeCode();
        if (dType_code!= null) {
            sqlBuilder.items(ModelTUuidChannelField.FI_TYPE_CODE);
        }
        Map<String, Object> param = ModelTUuidChannelField.MAP_OBJ_MAPPER.toCommonMap(instance);
        param.put("ids", ids);
        SimpleDbInterface dbInstance = data_store;
        return super.update(dbInstance, assembler, sqlBuilder, param);
    }

    public Integer updateByIds(ModelTUuidChannelField instance, Set<Integer> ids) {
        return updateByIds(instance, ids, null);
    }

    public Integer delete(ModelTUuidChannelField instance, Set<String> conditionField, DaoAssembler assembler) {
        SQLDelete sqlBuilder = SQL.buildDeleteSql(ModelTUuidChannelField.DTO_TABLE_NAME);
        Integer dId = instance.getId();
        if (conditionField.contains(ModelTUuidChannelField.FI_ID)) {
            assert((dId!= null));
            sqlBuilder.where(ModelTUuidChannelField.FI_ID, ColumnDataType.intData);
        }
        String dChannel_name = instance.getChannelName();
        if (conditionField.contains(ModelTUuidChannelField.FI_CHANNEL_NAME)) {
            assert((dChannel_name!= null));
            sqlBuilder.where(ModelTUuidChannelField.FI_CHANNEL_NAME, ColumnDataType.stringData);
        }
        Byte dType_code = instance.getTypeCode();
        if (conditionField.contains(ModelTUuidChannelField.FI_TYPE_CODE)) {
            assert((dType_code!= null));
            sqlBuilder.where(ModelTUuidChannelField.FI_TYPE_CODE, ColumnDataType.byteData);
        }
        Map<String, Object> param = ModelTUuidChannelField.MAP_OBJ_MAPPER.toCommonMap(instance);
        SimpleDbInterface dbInstance = data_store;
        return super.update(dbInstance, assembler, sqlBuilder, param);
    }

    public Integer delete(ModelTUuidChannelField instance, Set<String> conditionField) {
        return delete(instance, conditionField, null);
    }

    public Integer deleteById(Integer id, DaoAssembler assembler) {
        SQLDelete sqlBuilder = SQL.buildDeleteSql(ModelTUuidChannelField.DTO_TABLE_NAME);
        assert((id!= null));
        Map<String, Object> param = Collections.<String, Object>singletonMap("id", id);
        SimpleDbInterface dbInstance = data_store;
        return super.update(dbInstance, assembler, sqlBuilder, param);
    }

    public Integer deleteById(Integer id) {
        return deleteById(id, null);
    }

    public Integer deleteByIds(Set<Integer> ids, DaoAssembler assembler) {
        SQLDelete sqlBuilder = SQL.buildDeleteSql(ModelTUuidChannelField.DTO_TABLE_NAME);
        assert(((ids!= null)&&(ids.size()> 0)));
        Map<String, Object> param = Collections.<String, Object>singletonMap("ids", ids);
        SimpleDbInterface dbInstance = data_store;
        return super.update(dbInstance, assembler, sqlBuilder, param);
    }

    public Integer deleteByIds(Set<Integer> ids) {
        return deleteByIds(ids, null);
    }

    @Transactional
    public ModelTUuidChannelField updateOrInsert(ModelTUuidChannelField instance, Set<String> conditionField, AbstractMultipleDaoAssembler assembler) {
        if (assembler == null) {
            assembler = new BaseMultipleDaoAssembler();
        }
        ModelTUuidChannelField checkInstance = new ModelTUuidChannelField();
        if (conditionField.contains(ModelTUuidChannelField.FI_ID)) {
            checkInstance.setId(instance.getId());
        }
        if (conditionField.contains(ModelTUuidChannelField.FI_CHANNEL_NAME)) {
            checkInstance.setChannelName(instance.getChannelName());
        }
        if (conditionField.contains(ModelTUuidChannelField.FI_TYPE_CODE)) {
            checkInstance.setTypeCode(instance.getTypeCode());
        }
        ModelTUuidChannelField selected = getOneByCond(Collections.singleton(ModelTUuidChannelField.FI_ID), assembler, checkInstance);
        assembler.increaseIndex();
        if (selected == null) {
            ModelTUuidChannelField newInstance = insert(instance, assembler);
            newInstance.setInserted(true);
            return newInstance;
        } else {
            instance.setId(selected.getId());
            instance.setUpdateCount(update(instance, Collections.singleton(ModelTUuidChannelField.FI_ID), assembler));
            instance.setInserted(false);
            return instance;
        }
    }

    public ModelTUuidChannelField updateOrInsert(ModelTUuidChannelField instance, Set<String> conditionField) {
        return updateOrInsert(instance, conditionField, null);
    }

    @Transactional
    public ModelTUuidChannelField insertIfNoExist(ModelTUuidChannelField instance, Set<String> conditionField, AbstractMultipleDaoAssembler assembler) {
        if (assembler == null) {
            assembler = new BaseMultipleDaoAssembler();
        }
        ModelTUuidChannelField checkInstance = new ModelTUuidChannelField();
        if (conditionField.contains(ModelTUuidChannelField.FI_ID)) {
            checkInstance.setId(instance.getId());
        }
        if (conditionField.contains(ModelTUuidChannelField.FI_CHANNEL_NAME)) {
            checkInstance.setChannelName(instance.getChannelName());
        }
        if (conditionField.contains(ModelTUuidChannelField.FI_TYPE_CODE)) {
            checkInstance.setTypeCode(instance.getTypeCode());
        }
        ModelTUuidChannelField selected = getOneByCond(Collections.singleton(ModelTUuidChannelField.FI_ID), assembler, checkInstance);
        assembler.increaseIndex();
        if (selected == null) {
            ModelTUuidChannelField newInstance = insert(instance, assembler);
            newInstance.setInserted(true);
            return newInstance;
        } else {
            instance.setId(selected.getId());
            instance.setInserted(false);
            return instance;
        }
    }

    public ModelTUuidChannelField insertIfNoExist(ModelTUuidChannelField instance, Set<String> conditionField) {
        return insertIfNoExist(instance, conditionField, null);
    }

    public<TT> Map<TT, ModelTUuidChannelField> buildMap(List<ModelTUuidChannelField> list, String field) {
        Map<TT, ModelTUuidChannelField> ret = CollectionHelper.newMap();
        if (list == null) {
            return ret;
        }
        for (ModelTUuidChannelField item: list) {
            ret.put(ModelTUuidChannelField.MAP_OBJ_MAPPER.<TT> getField(field, item), item);
        }
        return ret;
    }

    public<TT> Map<TT, List<ModelTUuidChannelField>> buildListMap(List<ModelTUuidChannelField> list, String field) {
        Map<TT, List<ModelTUuidChannelField>> ret = CollectionHelper.newMap();
        if (list == null) {
            return ret;
        }
        for (ModelTUuidChannelField item: list) {
            List<ModelTUuidChannelField> itemList = ret.get(ModelTUuidChannelField.MAP_OBJ_MAPPER.<TT> getField(field, item));
            if (itemList == null) {
                itemList = CollectionHelper.newList();
            }
            itemList.add(item);
            ret.put(ModelTUuidChannelField.MAP_OBJ_MAPPER.<TT> getField(field, item), itemList);
        }
        return ret;
    }

    public<TT> List<TT> extractItemAsList(List<ModelTUuidChannelField> list, String field) {
        List<TT> ret = CollectionHelper.newList();
        if ((list == null)||(list.size() == 0)) {
            return ret;
        }
        if (ModelTUuidChannelField.FIELD_CLASS.containsKey(field)) {
            for (ModelTUuidChannelField item: list) {
                ret.add(ModelTUuidChannelField.MAP_OBJ_MAPPER.<TT> getField(field, item));
            }
        }
        return ret;
    }
}
