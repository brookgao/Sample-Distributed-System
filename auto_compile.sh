#!/bin/sh

echo "Start to compile.."
javac DATA/dataRecord.java
echo "dataRecord succeed.."

javac SERVER/SampleServer.java 
echo "SampleServer succeed.."

javac SERVER/SampleServerImpl.java
echo "SampleServerImpl succeed.."

javac DISPATCHER/SampleDispatcher.java 
echo "SampleDispatcher succeed.."

javac CLIENT/client.java
echo "CLIENT/client succeed.."




