package cars.mybatis.dao;

import cars.mybatis.model.Model;
import java.util.List;

public interface ModelMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.MODEL
     *
     * @mbg.generated Tue May 12 00:09:55 EEST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.MODEL
     *
     * @mbg.generated Tue May 12 00:09:55 EEST 2020
     */
    int insert(Model record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.MODEL
     *
     * @mbg.generated Tue May 12 00:09:55 EEST 2020
     */
    Model selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.MODEL
     *
     * @mbg.generated Tue May 12 00:09:55 EEST 2020
     */
    List<Model> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.MODEL
     *
     * @mbg.generated Tue May 12 00:09:55 EEST 2020
     */
    int updateByPrimaryKey(Model record);
}