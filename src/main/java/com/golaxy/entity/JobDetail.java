package com.golaxy.entity;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

/**
 * 招聘信息实体类
 * @author lx
 *
 */
public class JobDetail {
	/**唯一标识*/
	@SerializedName("_id")
	private String id;
	private transient int ch;
	/**网站名称*/
	private String sn;
	/**职位id*/
	private String jid;
	/**职位名称*/
	private String jn;
	/**公司id*/
	private String cid;
	/**公司名称*/
	private String cn;
	/**月薪*/
	private String jsal;
	/**工作地点*/
	private String jloc;
	/**发布时间*/
	private long pt;
	/**工作性质*/
	private String jpro;
	/**工作经历*/
	private String exp;
	/**最低学历*/
	private String edu;
	/**招聘人数*/
	private int rnum_n;
	/***/
	private String rnum_s;
	/**职位类别*/
	private String jclass;
	/**职位描述*/
	private String jdesc;
	/**公司简介*/
	private String cdesc;
	/**公司规模*/
	private String csize_s;
	/***/
	private int csize_n;
	/**公司性质*/
	private String cpro;
	/**公司行业*/
	private String cocu;
	/**公司主页*/
	private String chome;
	/**公司地址*/
	private String caddr;
	/**采集时间*/
	private long gt;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	public String getJid() {
		return jid;
	}
	public void setJid(String jid) {
		this.jid = jid;
	}
	public String getJn() {
		return jn;
	}
	public void setJn(String jn) {
		this.jn = jn;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getCn() {
		return cn;
	}
	public void setCn(String cn) {
		this.cn = cn;
	}
	public String getJsal() {
		return jsal;
	}
	public void setJsal(String jsal) {
		this.jsal = jsal;
	}
	public String getJloc() {
		return jloc;
	}
	public void setJloc(String jloc) {
		this.jloc = jloc;
	}
	public long getPt() {
		return pt;
	}
	public void setPt(long pt) {
		this.pt = pt;
	}
	public String getJpro() {
		return jpro;
	}
	public void setJpro(String jpro) {
		this.jpro = jpro;
	}
	public String getExp() {
		return exp;
	}
	public void setExp(String exp) {
		this.exp = exp;
	}
	public String getEdu() {
		return edu;
	}
	public void setEdu(String edu) {
		this.edu = edu;
	}
	public int getRnum_n() {
		return rnum_n;
	}
	public void setRnum_n(int rnum_n) {
		this.rnum_n = rnum_n;
	}
	public String getRnum_s() {
		return rnum_s;
	}
	public void setRnum_s(String rnum_s) {
		this.rnum_s = rnum_s;
	}
	public String getJclass() {
		return jclass;
	}
	public void setJclass(String jclass) {
		this.jclass = jclass;
	}
	public String getJdesc() {
		return jdesc;
	}
	public void setJdesc(String jdesc) {
		this.jdesc = jdesc;
	}
	public String getCdesc() {
		return cdesc;
	}
	public void setCdesc(String cdesc) {
		this.cdesc = cdesc;
	}
	public String getCsize_s() {
		return csize_s;
	}
	public void setCsize_s(String csize_s) {
		this.csize_s = csize_s;
	}
	public int getCsize_n() {
		return csize_n;
	}
	public void setCsize_n(int csize_n) {
		this.csize_n = csize_n;
	}
	public String getCpro() {
		return cpro;
	}
	public void setCpro(String cpro) {
		this.cpro = cpro;
	}
	public String getCocu() {
		return cocu;
	}
	public void setCocu(String cocu) {
		this.cocu = cocu;
	}
	public String getChome() {
		return chome;
	}
	public void setChome(String chome) {
		this.chome = chome;
	}
	public String getCaddr() {
		return caddr;
	}
	public void setCaddr(String caddr) {
		this.caddr = caddr;
	}
	public long getGt() {
		return gt;
	}
	public void setGt(long gt) {
		this.gt = gt;
	}
	
	public int getCh() {
		return ch;
	}
	public void setCh(int ch) {
		this.ch = ch;
	}
	@Override
	public String toString() {
		return "JobDetail [id=" + id + ", sn=" + sn + ", jid=" + jid + ", jn=" + jn + ", cid=" + cid + ", cn=" + cn
				+ ", jsal=" + jsal + ", jloc=" + jloc + ", pt=" + pt + ", jpro=" + jpro + ", exp=" + exp + ", edu="
				+ edu + ", rnum_n=" + rnum_n + ", rnum_s=" + rnum_s + ", jclass=" + jclass + ", jdesc=" + jdesc
				+ ", cdesc=" + cdesc + ", csize_s=" + csize_s + ", csize_n=" + csize_n + ", cpro=" + cpro + ", cocu="
				+ cocu + ", chome=" + chome + ", caddr=" + caddr + ", gt=" + gt + "]";
	}
public static void main(String[] args) {
	JobDetail jDetail = new JobDetail();
	jDetail.setCh(1);
	System.out.println(new Gson().toJson(jDetail));
}
	
}	
