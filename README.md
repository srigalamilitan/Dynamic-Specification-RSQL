# Implementation Dynamic Specification Using RSQL-Parser Example


###Update 2016 June 1st
1 Support Searching In Case Sensitif field Varchar using Upper 
  Tested On MariaDB. Maria Db default set Collaction 'utf8_general_ci' it's mean content of field default InCaseSensitive .
  So, Make your column collaction to be 'utf8_bin';
  ``` sql
  ALTER TABLE table_testing_rsql MODIFY
      varchar_test VARCHAR(100)
        CHARACTER SET utf8
        COLLATE utf8_bin;
  ``` 
2 Test Class AppStringInCaseSensitifRsqlTest.java  ;

3. Example 
  ``` java
  @Test
  public void testStringLikeAndUpperCase(){
      List<TableTestingRsql> data=rp.findBySpec("varcharTest==^ON*");
      assertTrue("1 Data Actually",data.size()==1);
  }
  ```
  
4. Character '^' tell us the query must using upper
    This is result generate SQL by Hibernate
    
    ``` sql
    SELECT 
      tabletesti0_.ID AS ID1_0_,
      tabletesti0_.BIG_DECIMAL_TEST AS BIG_DECI2_0_,
      tabletesti0_.CHAR_TEST AS CHAR_TES3_0_,
      tabletesti0_.DATE_TEST AS DATE_TES4_0_,
      tabletesti0_.DATE_TIME_TEST AS DATE_TIM5_0_,
      tabletesti0_.DOUBLE_TEST AS DOUBLE_T6_0_,
      tabletesti0_.FLOAT_TEST AS FLOAT_TE7_0_,
      tabletesti0_.INT_TEST AS INT_TEST8_0_,
      tabletesti0_.VARCHAR_TEST AS VARCHAR_9_0_ 
    FROM
      TABLE_TESTING_RSQL tabletesti0_ 
    WHERE UPPER(tabletesti0_.VARCHAR_TEST) LIKE ?
    ```
    
    
## Introducing 
>Changes Is Enemy, But We Must Prepared . -

I have been code with spring boot and thymeleaf, When  the *User Interface * add a new search criteria the backend code (my repository, service and controller) must changed too.  Honestly I don't like that. to much changing :(.
I try searching library to handle changes, so make minimum rewriting code when User Interface Changed.
And Woww Gotchaaaa... RSQL-PARSER

## What Is Rsql-Parser
> **RSQL-Parser** is a query language for parametrized filtering of entries in RESTful APIs. It’s based on FIQL (Feed Item Query Language) – an URI-friendly syntax for expressing filters across the entries in an Atom Feed. FIQL is great for use in URI; there  are no unsafe characters, so URL encoding is not required. On the other side, FIQL’s syntax is not very intuitive and URL encoding isn’t always that big deal, so RSQL also provides a friendlier syntax for logical operators and some of the comparison operators.-[Github Rsql parser](http://https://github.com/jirutka/rsql-parser)

Before we go to dev this is pom.xml i have used
1. spring-boot-starter-parent: 1.3.5
2. lombok :1.16.8 
3. mysql
4. rsql-parser : 2.1.0
5. commons-lang : 2.6
6. hibernate-java8 : 5.0.5.Final
7. java 8


####This Is my Table
``` sql
CREATE TABLE `table_testing_rsql` (
  `id` bigint(20) NOT NULL,
  `date_test` date DEFAULT NULL,
  `big_decimal_test` decimal(38,10) DEFAULT NULL,
  `date_time_test` datetime DEFAULT NULL,
  `varchar_test` varchar(100) DEFAULT NULL,
  `int_test` int(11) DEFAULT NULL,
  `float_test` float(10,1) DEFAULT NULL,
  `char_test` char(1) DEFAULT NULL,
  `double_test` double DEFAULT NULL,
  PRIMARY KEY (`id`)
)
```
i have try to cover all datatype we usually using in the application.

#### JPARsqlConverter.java
``` java
            if (op.equals(EQUAL)) {
                if (type.equals(String.class) && argument.toString().contains("*")) {
                    return builder.like(attrPath, argument.toString().replace('*', '%'));
                } else if (argument == null) {
                    return builder.isNull(attrPath);
                } else {
                    return builder.equal(attrPath, argument);
                }
            }
            if (op.equals(NOT_EQUAL)) {
                if (type.equals(String.class)  && argument.toString().contains("*")) {
                    return builder.notLike(attrPath, argument.toString().replace('*', '%'));
                } else if (argument == null) {
                    return builder.isNotNull(attrPath);
                } else {
                    return builder.notEqual(attrPath, argument);
                }
            }
```
All value String convert into Object appropriate with the Pojo Attribute DataType.
``` java
public Object castDynamicClass(Class dynamicClass, String value){
   Object object=null;
   try{
             Constructor<?> cons =(Constructor<?>) dynamicClass.getConstructor(new Class<?>[]{String.class});
                 object = cons.newInstance(new Object[]{value});
         
            return object;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
```

#### Implementation RSQL in Services layer
``` java
public List<TableTestingRsql> findBySpec(String p_filter) {
return repo.findAll(RsqlSpecification.<TableTestingRsql>rsql(p_filter));
    }
```

Simple Like That..
p_filter like this
- Where Clause Equals --> *bigDecimalTest==1234556.1234567890*
- Where Clause Not Equals -->*idTest!=1*
- Where Clause IN --> *charTest=in=(A,B)*
- Where Clause Not In --> *doubleTest=out=(1.456789,156789.56789)*
- Where Clause Grater Than -->*doubleTest=gt=156789.56789*
- Where Clause Less Than --> *floatTest=le=5.5*
- Where Clause Like --> *varcharTest==*ou**
- Where Clause Not Like --> *varcharTest!=*ou**
- Complex Query clausa --> *( dateTest=in=(2016-05-24,2016-05-25);intTest=in=(1,4)),idTest==5"*

>note :
Logical AND --> ;
Logical OR  --> ,-

i Have create 10 classes test too prove all is well.
And then , this is the result testing Junit.

| MySql Type | Java Type| Operator == | Operator != |  >> and >= | < and <=| IN(..)| Not IN (..) |
|:--------|:------|:--------:|:--------:|:--------:|:--------:|:--------:|:--------:|
|bigint|BigInteger|OK|OK|OK|OK|OK|OK|
|date|LocalDate|OK|OK|OK|OK|OK|OK|
|decimal|BigDecimal|OK|OK|OK|OK|OK|OK|
|datetime|LocalDateTime|OK|OK|OK|OK|OK|OK|
|varchar|String|OK|OK|OK|OK|OK|OK|
|int|Integer|OK|OK|OK|OK|OK|OK|
|float|Float|OK|OK|OK|OK|Not OK|Not OK|
|char|Character|OK|OK|OK|OK|OK|OK|
|double|Double|OK|OK|OK|OK|OK|OK|OK|



References
- [Github RSQL-parser](https://github.com/jirutka/rsql-parser)
- [Baeldung](http://www.baeldung.com/rest-api-search-language-rsql-fiql)
- [PutraCode.com](http://putracode.com/)
