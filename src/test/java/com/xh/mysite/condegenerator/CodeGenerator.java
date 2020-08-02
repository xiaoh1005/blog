package com.xh.mysite.condegenerator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableField;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;

/**
 * author  Xiao Hong
 * date  2020/5/2 0:15
 * description
 */

public class CodeGenerator {

    public static void main(String[] args) {
// 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("Xiao Hong");
        gc.setFileOverride(false);//覆盖配置
        gc.setServiceName("%sService");// 去Service I 前缀
        gc.setOpen(false);
        gc.setIdType(IdType.ID_WORKER);
        gc.setDateType(DateType.ONLY_DATE);
        gc.setSwagger2(true); //实体属性 Swagger2 注解
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/myblog?serverTimezone=GMT%2b8&useSSL=false&characterEncoding=utf8");
        // dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        dsc.setDbType(DbType.MYSQL);
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName("blog");
        pc.setParent("com.xh");
        pc.setEntity("pojo");
        pc.setController("rest");
        pc.setMapper("mapper");
        pc.setService("service");
        mpg.setPackageInfo(pc);


        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setInclude("");//todo. 设置 要 generate 的表
        strategy.setNaming(NamingStrategy.underline_to_camel);// 下划线转驼峰命名
        strategy.setColumnNaming(NamingStrategy.underline_to_camel); //列 驼峰
        strategy.setEntityLombokModel(true); // lombok 注解
        strategy.setLogicDeleteFieldName("deleted"); //逻辑删除 标识

            //自动填充策略
        ArrayList<TableFill> list = new ArrayList<>();
        TableFill field1 = new TableFill("gmt_create", FieldFill.INSERT);
        TableFill field2 = new TableFill("gmt_modified", FieldFill.INSERT_UPDATE);
        list.add(field1);
        list.add(field2);
        strategy.setTableFillList(list);
            //乐观锁
        strategy.setVersionFieldName("version");
            // controller 驼峰
        strategy.setRestControllerStyle(true);
            // api 下划线 如 localhost://user_id_2
        strategy.setControllerMappingHyphenStyle(true);
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();

    }
}
