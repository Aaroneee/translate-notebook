package org.autumn.translateNotebook.utils;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Generator {
    // 基础信息配置
    /**
     * 数据库连接字符
     */
    private static final String URL = "jdbc:mysql://localhost:3306/translate_notebook?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";

    /**
     * 包名
     */
    private static final String PARENT_PACKAGE_NAME = "com.autumn.translateNotebook";

    /**
     * 数据库用户名
     */
    private static final String USERNAME = "root";
    /**
     * 数据库密码
     */
    private static final String PASSWORD = "123456";
    /**
     * 项目根路径
     */
    private static final String PROJECT_ROOT_PATH = System.getProperty("user.dir");

    /**
     * 执行此处
     */
    public static void main(String[] args) {
        // 简单示例，适用于单模块项目
        simpleGenerator();
        // 完整示例，适用于多模块项目
//        completeGenerator();
    }

    /**
     * 【单模块】简单的实现方案
     */
    protected static void simpleGenerator() {

        // 包路径
        String packagePath = PROJECT_ROOT_PATH + "/src/main/java";
        // XML文件的路径
        String mapperXmlPath = PROJECT_ROOT_PATH + "/src/main/resources/mapper";

        // 开始执行代码生成
        FastAutoGenerator.create(URL, USERNAME, PASSWORD)
                // 1. 全局配置
                .globalConfig(builder -> builder
                        // 作者名称
                        .author("Aaron")
                        // 开启覆盖已生成的文件。注释掉则关闭覆盖。
                        // 禁止打开输出目录。注释掉则生成完毕后，自动打开生成的文件目录。
                        .disableOpenDir()
                        // 指定输出目录。如果指定，Windows生成至D盘根目录下，Linux or MAC 生成至 /tmp 目录下。
                        .outputDir(packagePath)
                        // 开启swagger2.注释掉则默认关闭。
                        // .enableSwagger()
                        // 指定时间策略。
                        .dateType(DateType.ONLY_DATE)
                        // 注释时间策略。
                        .commentDate("yyyy-MM-dd")
                )

                // 2. 包配置
                .packageConfig((scanner, builder) -> builder
                        .parent(PARENT_PACKAGE_NAME)
                        // 设置父表名
                        // mapper.xml 文件的路径。单模块下，其他文件路径默认即可。

                )

                // 3. 策略配置
                .strategyConfig((scanner, builder) -> builder.addInclude(getTables(scanner.apply("请输入表名，多个英文逗号分隔？生成所有表，请输入[all]：")))
                        //设置表前缀
                        .addTablePrefix("t_")
                        // 阶段1：Entity实体类策略配置
                        .entityBuilder()
                        //实体类生成常量字段
                        .enableColumnConstant()
                        // 开启生成实体时生成字段注解。
                        // 会在实体类的属性前，添加[@TableField("nickname")]
                        .enableTableFieldAnnotation()
                        .enableLombok()
                        // 阶段2：Mapper策略配置
                        .mapperBuilder()
                        // 开启 @Mapper 注解。
                        // 启用 BaseResultMap 生成。
                        // 会在mapper.xml文件生成[通用查询映射结果]配置。
                        .enableBaseResultMap()
                        // 启用 BaseColumnList。
                        // 会在mapper.xml文件生成[通用查询结果列 ]配置
                        .enableBaseColumnList()
                        // 阶段4：Controller策略配置
                        .controllerBuilder()
                        // 会在控制类中加[@RestController]注解。
                        .enableRestStyle()
                        // 开启驼峰转连字符
                        .enableHyphenStyle()
                        .build()
                )

                // 4. 模板引擎配置，默认 Velocity 可选模板引擎 Beetl 或 Freemarker
                //.templateEngine(new BeetlTemplateEngine())
                .templateEngine(new VelocityTemplateEngine())

                // 5. 执行
                .execute();
    }

    // 处理 all 情况
    protected static List<String> getTables(String tables) {
        return "all".equals(tables) ? Collections.emptyList() : Arrays.asList(tables.split(","));
    }


}
