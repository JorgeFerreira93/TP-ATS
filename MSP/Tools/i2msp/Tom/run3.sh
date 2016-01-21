#/bin/bash
EXAMPLE_DIR=exemplos/
EXAMPLE_FILE=maiorDeDoisNumeros.i
RES_FILE=res.msp

cp $EXAMPLE_DIR$EXAMPLE_FILE genI
cd genI
javac gram/Main.java
java gram/Main