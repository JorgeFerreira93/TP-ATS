#/bin/bash
EXMAPLE_DIR=exemplos/
EXAMPLE_FILE=maiorDeDoisNumeros.i
RES_FILE=res.msp

make all
cp $EXAMPLE_DIR$EXAMPLE_FILE genI
cd genI
javac gram/Main.java
java gram/Main < $EXAMPLE_FILE > $RES_FILE

cp $RES_FILE ../genMaqV
cd ../genMaqV
javac maqv/Main.java
java maqv/Main $RES_FILE