package jjm.learn.book.sale.POJO;

public class OwnerInformationPOJO {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column owerinfo.id
     *
     * @mbggenerated Mon Dec 09 04:06:41 EST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column owerinfo.name
     *
     * @mbggenerated Mon Dec 09 04:06:41 EST 2019
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column owerinfo.sex
     *
     * @mbggenerated Mon Dec 09 04:06:41 EST 2019
     */
    private String sex;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column owerinfo.phoneNumber
     *
     * @mbggenerated Mon Dec 09 04:06:41 EST 2019
     */
    private String phonenumber;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column owerinfo.id
     *
     * @return the value of owerinfo.id
     *
     * @mbggenerated Mon Dec 09 04:06:41 EST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column owerinfo.id
     *
     * @param id the value for owerinfo.id
     *
     * @mbggenerated Mon Dec 09 04:06:41 EST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column owerinfo.name
     *
     * @return the value of owerinfo.name
     *
     * @mbggenerated Mon Dec 09 04:06:41 EST 2019
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column owerinfo.name
     *
     * @param name the value for owerinfo.name
     *
     * @mbggenerated Mon Dec 09 04:06:41 EST 2019
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column owerinfo.sex
     *
     * @return the value of owerinfo.sex
     *
     * @mbggenerated Mon Dec 09 04:06:41 EST 2019
     */
    public String getSex() {
        return sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column owerinfo.sex
     *
     * @param sex the value for owerinfo.sex
     *
     * @mbggenerated Mon Dec 09 04:06:41 EST 2019
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column owerinfo.phoneNumber
     *
     * @return the value of owerinfo.phoneNumber
     *
     * @mbggenerated Mon Dec 09 04:06:41 EST 2019
     */
    public String getPhonenumber() {
        return phonenumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column owerinfo.phoneNumber
     *
     * @param phonenumber the value for owerinfo.phoneNumber
     *
     * @mbggenerated Mon Dec 09 04:06:41 EST 2019
     */
    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber == null ? null : phonenumber.trim();
    }
}