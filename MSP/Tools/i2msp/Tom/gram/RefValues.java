/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PedroJosé
 */
public class RefValues {
    private float repoFunctLines,repoFunctArgs,repoFunctLocalVars;
    private int comFunctLines,comFunctArgs,comFunctLocalVars;
    private float rvFL,rvFA,rvFLV;

    public RefValues() {
    this.comFunctArgs=0;
    this.comFunctLines=0;
    this.comFunctLocalVars=0;
    this.repoFunctArgs=0;
    this.repoFunctLines=0;
    this.repoFunctLocalVars=0;
    this.rvFA=0;
    this.rvFL=0;
    this.rvFLV=0;
    }
    
    public RefValues(float repoFunctLines, float repoFunctArgs, float repoFunctLocalVars, int comFunctLines, int comFunctArgs, int comFunctLocalVars){
        this.repoFunctLines = repoFunctLines;
        this.repoFunctArgs = repoFunctArgs;
        this.repoFunctLocalVars = repoFunctLocalVars;
        this.comFunctLines = comFunctLines;
        this.comFunctArgs = comFunctArgs;
        this.comFunctLocalVars = comFunctLocalVars;
        this.rvFA=(repoFunctArgs+comFunctArgs)/2;
        this.rvFL=(repoFunctLines+comFunctLines)/2;
        this.rvFLV=(repoFunctLocalVars+comFunctLocalVars)/2;
    }

    public RefValues(float repoFunctLines, float repoFunctArgs, float repoFunctLocalVars, int comFunctLines, int comFunctArgs, int comFunctLocalVars, float rvFL, float rvFA, float rvFLV) {
        this.repoFunctLines = repoFunctLines;
        this.repoFunctArgs = repoFunctArgs;
        this.repoFunctLocalVars = repoFunctLocalVars;
        this.comFunctLines = comFunctLines;
        this.comFunctArgs = comFunctArgs;
        this.comFunctLocalVars = comFunctLocalVars;
        this.rvFL = rvFL;
        this.rvFA = rvFA;
        this.rvFLV = rvFLV;
    }

    public int getComFunctArgs() {
        return comFunctArgs;
    }

    public int getComFunctLines() {
        return comFunctLines;
    }

    public int getComFunctLocalVars() {
        return comFunctLocalVars;
    }

    public float getRepoFunctArgs() {
        return repoFunctArgs;
    }

    public float getRepoFunctLines() {
        return repoFunctLines;
    }

    public float getRepoFunctLocalVars() {
        return repoFunctLocalVars;
    }

    public float getRvFunctionArgs() {
        return rvFA;
    }

    public float getRvFunctionLines() {
        return rvFL;
    }

    public float getRvFunctionLocalVars() {
        return rvFLV;
    }

    public void setComFunctArgs(int comFunctArgs) {
        this.comFunctArgs = comFunctArgs;
    }

    public void setComFunctLines(int comFunctLines) {
        this.comFunctLines = comFunctLines;
    }

    public void setComFunctLocalVars(int comFunctLocalVars) {
        this.comFunctLocalVars = comFunctLocalVars;
    }

    public void setRepoFunctArgs(float repoFunctArgs) {
        this.repoFunctArgs = repoFunctArgs;
    }

    public void setRepoFunctLines(float repoFunctLines) {
        this.repoFunctLines = repoFunctLines;
    }

    public void setRepoFunctLocalVars(float repoFunctLocalVars) {
        this.repoFunctLocalVars = repoFunctLocalVars;
    }

    public void setRvFA(float rvFA) {
        this.rvFA = rvFA;
    }

    public void setRvFL(float rvFL) {
        this.rvFL = rvFL;
    }

    public void setRvFLV(float rvFLV) {
        this.rvFLV = rvFLV;
    }
    
    
    public void updateReferenceValues(int perc){
        float repoPerc=(100-perc)/100;
        float comPerc=perc/100;
        this.rvFA=repoPerc*repoFunctArgs+comPerc*comFunctArgs;
        this.rvFL=repoPerc*repoFunctLines+comPerc*comFunctLines;
        this.rvFLV=repoPerc*repoFunctLocalVars+comPerc*comFunctLocalVars;
    }
}
