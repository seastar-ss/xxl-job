/**
 * don't modify , it is generate automatically, any modification will be lost after regeneration next time
 * 
 * @author shawn-ss's auto writer
 */
package com.shangde.uuid_job.executor.dto.basepo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.Set;
import com.shawn.ss.lib.tools.CollectionHelper;
import com.shawn.ss.lib.tools.TypeConstantHelper;
import com.shawn.ss.lib.tools.db.api.interfaces.mappers._ObjMapper;
import com.shawn.ss.lib.tools.db.api.interfaces.mappers.db.DbResultSetMapper;
import com.shawn.ss.lib.tools.db.api.interfaces.mappers.db.RedisMapMapper;
import com.shawn.ss.lib.tools.db.dto_base.model.AbstractBaseModel;
import com.shawn.ss.lib.tools.db.impl.mapper.BaseDbMapper;


/**
 * base DTO,represent for table :t_uuid_channel_field
 * 	
 */
public class ModelTUuidChannelField
    extends AbstractBaseModel
{
    public final static String PRIMARY_KEY_NAME = "id";
    public final static String DTO_TABLE_NAME = "t_uuid_channel_field";
    public final static String DTO_DB_NAME = null;
    public final static Integer DTO_MODEL_TYPE = 0;
    /**
     * 对应数据库.t_uuid_channel_field.id 字段
     * 主键
     */
    Integer id;
    public final static String FI_ID = "id";
    /**
     * 对应数据库.t_uuid_channel_field.channel_name 字段
     * 渠道号
     */
    String channelName;
    public final static String FI_CHANNEL_NAME = "channel_name";
    /**
     * 对应数据库.t_uuid_channel_field.type_code 字段
     * t_uuid_variable_type表 variable_code -1表示所有
     */
    Byte typeCode;
    public final static String FI_TYPE_CODE = "type_code";
    public final static Map<String, Object> FIELD_CLASS = CollectionHelper.<String, Object> mapBuilder().put(ModelTUuidChannelField.FI_ID, Integer.class).put(ModelTUuidChannelField.FI_CHANNEL_NAME, String.class).put(ModelTUuidChannelField.FI_TYPE_CODE, Byte.class).getMap();
    public final static Integer FIELD_COUNT = 3;
    public final static ResultSetMapperModelTUuidChannelField<ModelTUuidChannelField> RESULT_SET_OBJ_MAPPER = new ResultSetMapperModelTUuidChannelField<com.shangde.uuid_job.executor.dto.basepo.ModelTUuidChannelField>();
    public final static ByteMapMapperModelTUuidChannelField MAP_OBJ_MAPPER = new ByteMapMapperModelTUuidChannelField();

    public ModelTUuidChannelField() {
    }

    public Integer getId() {
        return id;
    }

    public ModelTUuidChannelField setId(Integer lId) {
        id = lId;
        return this;
    }

    public String getChannelName() {
        return channelName;
    }

    public ModelTUuidChannelField setChannelName(String lChannelName) {
        channelName = lChannelName;
        return this;
    }

    public Byte getTypeCode() {
        return typeCode;
    }

    public ModelTUuidChannelField setTypeCode(Byte lTypeCode) {
        typeCode = lTypeCode;
        return this;
    }

    @Override
    public Map<String, Object> getFieldConfig() {
        return FIELD_CLASS;
    }

    public boolean isEmpty() {
        if (!super.isEmpty()) {
            return false;
        }
        if (getId()!= null) {
            return false;
        }
        if (getChannelName()!= null) {
            return false;
        }
        if (getTypeCode()!= null) {
            return false;
        }
        return true;
    }

    public<FT extends _ObjMapper> FT getFeature(Class<FT> clazz) {
        if (RedisMapMapper.class.isAssignableFrom(clazz)) {
            return ((FT) ModelTUuidChannelField.MAP_OBJ_MAPPER);
        }
        if (DbResultSetMapper.class.isAssignableFrom(clazz)) {
            return ((FT) ModelTUuidChannelField.RESULT_SET_OBJ_MAPPER);
        }
        return null;
    }

    public String toString() {
        StringBuilder ret = new StringBuilder();
        ret.append("{").append("id").append(":").append(id).append("}\n");
        ret.append("{").append("channelName").append(":").append(channelName).append("}\n");
        ret.append("{").append("typeCode").append(":").append(typeCode).append("}\n");
        return ret.toString();
    }

    public static class ByteMapMapperModelTUuidChannelField
        implements RedisMapMapper<ModelTUuidChannelField>
    {

        @Override
        public ModelTUuidChannelField fromMap(Map<byte[], byte[]> map) {
            ModelTUuidChannelField instance = new ModelTUuidChannelField();
            Set<Map.Entry<byte[], byte[]>> entries = map.entrySet();
            for (Map.Entry<byte[], byte[]> entry: entries) {
                String field = new String(entry.getKey());
                if (field.equals(ModelTUuidChannelField.FI_ID)) {
                    instance.setId(mapToFieldId(entry.getValue()));
                } else {
                    if (field.equals(ModelTUuidChannelField.FI_CHANNEL_NAME)) {
                        instance.setChannelName(mapToFieldChannelName(entry.getValue()));
                    } else {
                        if (field.equals(ModelTUuidChannelField.FI_TYPE_CODE)) {
                            instance.setTypeCode(mapToFieldTypeCode(entry.getValue()));
                        }
                    }
                }
            }
            return instance;
        }

        protected Integer mapToFieldId(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Integer.class);
        }

        protected String mapToFieldChannelName(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected Byte mapToFieldTypeCode(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Byte.class);
        }

        @Override
        public Map<byte[], byte[]> toMap(ModelTUuidChannelField instance) {
            Map<byte[], byte[]> ret = CollectionHelper.newMap();
            if (instance == null) {
                return ret;
            }
            byte[] valueId = mapFromFieldId(instance.getId());
            ret.put(ModelTUuidChannelField.FI_ID.getBytes(), valueId);
            byte[] valueChannel_name = mapFromFieldChannelName(instance.getChannelName());
            ret.put(ModelTUuidChannelField.FI_CHANNEL_NAME.getBytes(), valueChannel_name);
            byte[] valueType_code = mapFromFieldTypeCode(instance.getTypeCode());
            ret.put(ModelTUuidChannelField.FI_TYPE_CODE.getBytes(), valueType_code);
            return ret;
        }

        protected byte[] mapFromFieldId(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldChannelName(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldTypeCode(Byte field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        @Override
        public Map<String, Object> toCommonMap(ModelTUuidChannelField instance) {
            Map<String, Object> ret = CollectionHelper.newMap();
            if (instance == null) {
                return ret;
            }
            Integer dId = instance.getId();
            if (dId!= null) {
                ret.put(ModelTUuidChannelField.FI_ID, dId);
            }
            String dChannel_name = instance.getChannelName();
            if (dChannel_name!= null) {
                ret.put(ModelTUuidChannelField.FI_CHANNEL_NAME, dChannel_name);
            }
            Byte dType_code = instance.getTypeCode();
            if (dType_code!= null) {
                ret.put(ModelTUuidChannelField.FI_TYPE_CODE, dType_code);
            }
            return ret;
        }

        @Override
        public ModelTUuidChannelField fromCommonMap(Map<String, Object> param) {
            ModelTUuidChannelField ret = new ModelTUuidChannelField();
            if (param == null) {
                return ret;
            }
            Object dId = param.get(ModelTUuidChannelField.FI_ID);
            if (dId!= null) {
                this.setField(ModelTUuidChannelField.FI_ID, ret, dId);
            }
            Object dChannel_name = param.get(ModelTUuidChannelField.FI_CHANNEL_NAME);
            if (dChannel_name!= null) {
                this.setField(ModelTUuidChannelField.FI_CHANNEL_NAME, ret, dChannel_name);
            }
            Object dType_code = param.get(ModelTUuidChannelField.FI_TYPE_CODE);
            if (dType_code!= null) {
                this.setField(ModelTUuidChannelField.FI_TYPE_CODE, ret, dType_code);
            }
            return ret;
        }

        protected Integer mapToFieldId(Object obj) {
            return ((Integer) obj);
        }

        protected String mapToFieldChannelName(Object obj) {
            return ((String) obj);
        }

        protected Byte mapToFieldTypeCode(Object obj) {
            return ((Byte) obj);
        }

        public<TT> TT getField(String field, ModelTUuidChannelField instance) {
            try {
                if (field.equals(ModelTUuidChannelField.FI_ID)) {
                    return ((TT) instance.getId());
                } else {
                    if (field.equals(ModelTUuidChannelField.FI_CHANNEL_NAME)) {
                        return ((TT) instance.getChannelName());
                    } else {
                        if (field.equals(ModelTUuidChannelField.FI_TYPE_CODE)) {
                            return ((TT) instance.getTypeCode());
                        }
                    }
                }
            } catch (final Exception ex) {
                ex.printStackTrace();
            }
            return null;
        }

        public<TT> void setField(String field, ModelTUuidChannelField instance, TT value) {
            if (field.equals(ModelTUuidChannelField.FI_ID)) {
                try {
                    instance.setId(mapToFieldId(value));
                } catch (final Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                if (field.equals(ModelTUuidChannelField.FI_CHANNEL_NAME)) {
                    try {
                        instance.setChannelName(mapToFieldChannelName(value));
                    } catch (final Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    if (field.equals(ModelTUuidChannelField.FI_TYPE_CODE)) {
                        try {
                            instance.setTypeCode(mapToFieldTypeCode(value));
                        } catch (final Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }
        }

        public void setField(String field, ModelTUuidChannelField instance, byte[] value) {
            if (field.equals(ModelTUuidChannelField.FI_ID)) {
                instance.setId(mapToFieldId(value));
            } else {
                if (field.equals(ModelTUuidChannelField.FI_CHANNEL_NAME)) {
                    instance.setChannelName(mapToFieldChannelName(value));
                } else {
                    if (field.equals(ModelTUuidChannelField.FI_TYPE_CODE)) {
                        instance.setTypeCode(mapToFieldTypeCode(value));
                    }
                }
            }
        }
    }

    public static class ResultSetMapperModelTUuidChannelField<T extends ModelTUuidChannelField>
        extends BaseDbMapper<T>
        implements DbResultSetMapper<T>
    {

        @Override
        public T mapRow(ResultSet rs, int rowNum, Set<String> columnNames)
            throws SQLException
        {
            T instance = buildInstance();
            return mapRow(instance, rs, rowNum, columnNames);
        }

        protected T buildInstance() {
            return ((T) new ModelTUuidChannelField());
        }

        @Override
        public T mapRow(T instance, ResultSet rs, int rowNum, Set<String> columnNames)
            throws SQLException
        {
            mapFieldId(rs, columnNames, instance);
            mapFieldChannel_name(rs, columnNames, instance);
            mapFieldType_code(rs, columnNames, instance);
            instance.setIndex(rowNum);
            return instance;
        }

        protected void mapFieldId(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTUuidChannelField.FI_ID)) {
                instance.setId(rs.getInt(ModelTUuidChannelField.FI_ID));
            }
        }

        protected void mapFieldChannel_name(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTUuidChannelField.FI_CHANNEL_NAME)) {
                instance.setChannelName(rs.getString(ModelTUuidChannelField.FI_CHANNEL_NAME));
            }
        }

        protected void mapFieldType_code(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTUuidChannelField.FI_TYPE_CODE)) {
                instance.setTypeCode(rs.getByte(ModelTUuidChannelField.FI_TYPE_CODE));
            }
        }
    }
}
