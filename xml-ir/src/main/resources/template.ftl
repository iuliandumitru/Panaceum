<#-- @ftlvariable name="compilationUnit" type="japa.parser.ast.CompilationUnit" -->
<#assign imports = compilationUnit.imports />
<#assign declarationTypes = compilationUnit.types />


<unit>

    <package name="${packageName}"/>

    <imports>
    <#list imports as import>
        <import>${import.name.name}</import>
    </#list>
    </imports>


<#list declarationTypes as declarationType>

    <${declarationType.name}>

    </${declarationType.name}>

</#list>




<class name="${compilationUnit.types.get(0).name}" extends="${compilationUnit.types.get(0)}">

    <field name="byMap" type="Map" isFinal="false"/>
    <field name="keyFunction" type="PipeFunction" isFinal="true"/>
    <field name="valueFunction" type="PipeFunction" isFinal="true"/>
    <field name="reduceFunction" type="PipeFunction" isFinal="true"/>
    <field name="reduceMap" type="Map" isFinal="false"/>


    <constructor modifier="public">
        <parameters>
            <parameter name="keyFunction" type="PipeFunction"/>
            <parameter name="valueFunction" type="PipeFunction"/>
            <parameter name="reduceFunction" type="PipeFunction"/>
        </parameters>
    </constructor>

    <constructor modifier="public">
        <parameters>
            <parameter name="reduceMap" type="Map"/>
            <parameter name="keyFunction" type="PipeFunction"/>
            <parameter name="valueFunction" type="PipeFunction"/>
            <parameter name="reduceFunction" type="PipeFunction"/>
        </parameters>
    </constructor>

    <method name="processNextStart" modifer="protected" isFinal="false" isAbstract="false">
    </method>

    <method name="addValue" modifer="public" isFinal="false" isAbstract="false">
        <parameters>
            <parameter name="value" type="V"/>
            <parameter name="values" type="ExpandableMultiIterator"/>
        </parameters>
        <body>
        <stmt type="IfStmt"/>
        </body>
    </method>

    <method name="getSideEffect" modifer="public" isFinal="false" isAbstract="false">
    </method>

    <method name="getKey" modifer="private" isFinal="false" isAbstract="false">
        <parameters>
            <parameter name="start" type="S"/>
        </parameters>
        <body>
        <stmt type="IfStmt"/>
        </body>
    </method>

    <method name="getValue" modifer="private" isFinal="false" isAbstract="false">
        <parameters>
            <parameter name="start" type="S"/>
        </parameters>
        <body>
        <stmt type="IfStmt"/>
        </body>
    </method>

    <method name="reset" modifer="public" isFinal="false" isAbstract="false">
    </method>

</class>

</unit>

