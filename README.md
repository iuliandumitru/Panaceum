Panaceum
========

High level virtual machine


This is a academic project. The scope is to learn compiler/virtual machines technologies.
The backend of the virtual machine will be the JVM first, later other options will be investigated (LLVM/C etc).
The intermediate representation / bytecode of the VM is XML. The decision was made because XML is multiplatform easy to generate/transform.
The language implementation for the compiler/MV is Scala.
In theory any language could run on the VM, but for the moment only garbage collected ones will be studied.
At a later time, a custom language will be designed.


The first early draft of the intermediate language can be seen at /xml-ir/src/main/resources/example.xml    .
The purpose is to design a generic nut flexible language.

A first draft of a Java to XML IR translator was started (written in Scala).