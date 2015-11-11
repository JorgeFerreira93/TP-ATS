DIR1=gram
GEN_DIR1=genI
PKG1=gram
TOM1=Main
GOM1=i
ANTLR1=i
DIR2=maqv
GEN_DIR2=genMaqV
PKG2=maqv
TOM2=Main
GOM2=msp
ANTLR2=msp

all: gram maqv

gram: gom1 antlr1 tom1 

gom1:  $(DIR1)/$(GOM1).gom 
	#gom --termgraph -d $(GEN_DIR1) $(DIR1)/$(GOM1).gom
	gom -d $(GEN_DIR1) $(DIR1)/$(GOM1).gom
	gomantlradaptor -d $(GEN_DIR1) -p $(PKG1) $(DIR1)/$(GOM1).gom
	
antlr1: $(DIR1)/$(ANTLR1).g
	java org.antlr.Tool -o $(GEN_DIR1) -lib $(GEN_DIR1)/$(PKG1)/$(GOM1)/ $(DIR1)/$(ANTLR1).g

tom1: $(DIR1)/$(TOM1).t
	tom -d $(GEN_DIR1) $(DIR1)/$(TOM1).t

run:
	cd $(GEN_DIR1); \ java $(PKG1)/$(TOM1)

cleangram: 
	rm -r $(GEN_DIR1)

clean: cleanmaqv
	rm -r $(GEN_DIR1)

maqv: gom2 antlr2 tom2 

gom2:  $(DIR2)/$(GOM2).gom 
	#gom --termgraph -d $(GEN_DIR2) $(DIR2)/$(GOM2).gom
	gom -d $(GEN_DIR2) $(DIR2)/$(GOM2).gom
	gomantlradaptor -d $(GEN_DIR2) -p $(PKG2) $(DIR2)/$(GOM2).gom

antlr2: $(DIR2)/$(ANTLR2).g
	java org.antlr.Tool -o $(GEN_DIR2) -lib $(GEN_DIR2)/$(PKG2)/$(GOM2)/ $(DIR2)/$(ANTLR2).g

tom2: $(DIR2)/$(TOM2).t
	tom -d $(GEN_DIR2) $(DIR2)/$(TOM2).t

cleanmaqv:
	rm -r $(GEN_DIR2)
