package com.guoxi.vo;
public class Datas
{
    private String channel;

    private String metric;

    private String producer;

    private String sn;

    private String time;

    private Double value;

    public void setChannel(String channel)
    {
        this.channel = channel;
    }
    public String getChannel()
    {
        return this.channel;
    }
    public void setMetric(String metric)
    {
        this.metric = metric;
    }
    public String getMetric(){

        return this.metric;
    }
    public void setProducer(String producer)
    {
        this.producer = producer;
    }
    public String getProducer(){

        return this.producer;
    }
    public void setSn(String sn)
    {
        this.sn = sn;
    }
    public String getSn(){

        return this.sn;
    }
    public void setTime(String time)
    {
        this.time = time;
    }
    public String getTime()
    {
        return this.time;
    }
	public Double getValue()
    {
		return value;
	}
	public void setValue(Double value)
    {
		this.value = value;
	}
}

