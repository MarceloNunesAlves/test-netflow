package br.com.flexvision.dto;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

public class Flow {

	private Instant epochTime;
	
	private long srcPort;
	private long output;
	private long dstPort;
	private long prot;
	/*Metrica*/
	private long dPkts;
	/*********/
	private long tos;
	private long tcpFlags;
	private long dstAs;
	private long dstMask;
	/*Metrica*/
	private long count;
	/*********/
	private int version;
	/*Metrica*/
	private long dOctets;
	/*********/
	private long input;
	private String srcAddr;
	private String dstAddr;
	private long srcMask;
	private long srcAs;
	private String nextHop;

    @JsonGetter
    private long getImportDate() {
        return this.epochTime.toEpochMilli();
    }
    @JsonSetter
    private void setImportDate(long time) {
        this.epochTime = Instant.ofEpochMilli(time);
    }
    @JsonIgnore
	public Instant getEpochTime() {
		return epochTime;
	}
	public void setEpochTime(Instant epochTime) {
		this.epochTime = epochTime;
	}
	public long getSrcPort() {
		return srcPort;
	}
	public void setSrcPort(long srcPort) {
		this.srcPort = srcPort;
	}
	public long getOutput() {
		return output;
	}
	public void setOutput(long output) {
		this.output = output;
	}
	public long getDstPort() {
		return dstPort;
	}
	public void setDstPort(long dstPort) {
		this.dstPort = dstPort;
	}
	public long getProt() {
		return prot;
	}
	public void setProt(long prot) {
		this.prot = prot;
	}
	public long getdPkts() {
		return dPkts;
	}
	public void setdPkts(long dPkts) {
		this.dPkts = dPkts;
	}
	public long getTos() {
		return tos;
	}
	public void setTos(long tos) {
		this.tos = tos;
	}
	public long getTcpFlags() {
		return tcpFlags;
	}
	public void setTcpFlags(long tcpFlags) {
		this.tcpFlags = tcpFlags;
	}
	public long getDstAs() {
		return dstAs;
	}
	public void setDstAs(long dstAs) {
		this.dstAs = dstAs;
	}
	public long getDstMask() {
		return dstMask;
	}
	public void setDstMask(long dstMask) {
		this.dstMask = dstMask;
	}
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public long getdOctets() {
		return dOctets;
	}
	public void setdOctets(long dOctets) {
		this.dOctets = dOctets;
	}
	public long getInput() {
		return input;
	}
	public void setInput(long input) {
		this.input = input;
	}
	public String getSrcAddr() {
		return srcAddr;
	}
	public void setSrcAddr(String srcAddr) {
		this.srcAddr = srcAddr;
	}
	public String getDstAddr() {
		return dstAddr;
	}
	public void setDstAddr(String dstAddr) {
		this.dstAddr = dstAddr;
	}
	public long getSrcMask() {
		return srcMask;
	}
	public void setSrcMask(long srcMask) {
		this.srcMask = srcMask;
	}
	public long getSrcAs() {
		return srcAs;
	}
	public void setSrcAs(long srcAs) {
		this.srcAs = srcAs;
	}
	public String getNextHop() {
		return nextHop;
	}
	public void setNextHop(String nextHop) {
		this.nextHop = nextHop;
	}

}
