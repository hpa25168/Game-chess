#!/bin/bash -ex
mvn -q clean
mvn -q compile
mvn exec:java -Dprism.order=sw -Dexec.mainClass="project.chess.ChessDriver"
