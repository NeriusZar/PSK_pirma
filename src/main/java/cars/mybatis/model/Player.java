package cars.mybatis.model;

public class Player {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.PLAYER.ID
     *
     * @mbg.generated Sun Mar 03 13:45:02 EET 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.PLAYER.NAME
     *
     * @mbg.generated Sun Mar 03 13:45:02 EET 2019
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.PLAYER.TEAM_ID
     *
     * @mbg.generated Sun Mar 03 13:45:02 EET 2019
     */
    private Integer teamId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.PLAYER.ID
     *
     * @return the value of PUBLIC.PLAYER.ID
     *
     * @mbg.generated Sun Mar 03 13:45:02 EET 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.PLAYER.ID
     *
     * @param id the value for PUBLIC.PLAYER.ID
     *
     * @mbg.generated Sun Mar 03 13:45:02 EET 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.PLAYER.NAME
     *
     * @return the value of PUBLIC.PLAYER.NAME
     *
     * @mbg.generated Sun Mar 03 13:45:02 EET 2019
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.PLAYER.NAME
     *
     * @param name the value for PUBLIC.PLAYER.NAME
     *
     * @mbg.generated Sun Mar 03 13:45:02 EET 2019
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.PLAYER.TEAM_ID
     *
     * @return the value of PUBLIC.PLAYER.TEAM_ID
     *
     * @mbg.generated Sun Mar 03 13:45:02 EET 2019
     */
    public Integer getTeamId() {
        return teamId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.PLAYER.TEAM_ID
     *
     * @param teamId the value for PUBLIC.PLAYER.TEAM_ID
     *
     * @mbg.generated Sun Mar 03 13:45:02 EET 2019
     */
    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }
}