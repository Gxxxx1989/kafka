package com.guoxi.vo;
import java.util.List;
public class Root
{
    private List<Datas> datas;

    private String ver;

    public void setDatas(List<Datas> datas)
    {
        this.datas = datas;
    }
    public List<Datas> getDatas()
    {
        return this.datas;
    }
    public void setVer(String ver)
    {
        this.ver = ver;
    }
    public String getVer()
    {
        return this.ver;
    }
}
