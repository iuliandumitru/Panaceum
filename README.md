Panaceum
========

High level virtual machine


This is a academic project. The scope is to learn compiler/virtual machines technology.
The backend of the virtual machine will be the JVM first, later other options will be investigated (C/LLVM backend).
The intermediate representation / bytecode of the VM is XML. The decision was made because XML is multiplatform easy to generate/transform.
The language implementation is Scala.
At a later time, a custom language will be designed.

In theory any language could run on the VM, but for the moment only garbage collected ones will be studied.