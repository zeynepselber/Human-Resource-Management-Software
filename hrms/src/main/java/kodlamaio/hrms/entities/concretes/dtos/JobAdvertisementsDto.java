package kodlamaio.hrms.entities.concretes.dtos;

import java.time.LocalDate;

public class JobAdvertisementsDto {

	private String description;
	private Double minSalary;
	private Double maxSalary;
	private int openPositionCount;
	private LocalDate lastApplyDate;
	private boolean isActive;
	private int cityId;
	private int jobPositionId;
	private int employerId;
	
	public JobAdvertisementsDto() {
		super();
	}
	
	public JobAdvertisementsDto(String description, Double minSalary, Double maxSalary, int openPositionCount,
			LocalDate lastApplyDate, boolean isActive, int cityId, int jobPositionId, int employerId) {
		super();
		this.description       = description;
		this.minSalary         = minSalary;
		this.maxSalary         = maxSalary;
		this.openPositionCount = openPositionCount;
		this.lastApplyDate     = lastApplyDate;
		this.isActive          = isActive;
		this.cityId            = cityId;
		this.jobPositionId     = jobPositionId;
		this.employerId        = employerId;
	}

	public String getDescription() { return description; }

	public void setDescription(String description) { this.description = description; }

	public Double getMinSalary() { return minSalary; }

	public void setMinSalary(Double minSalary) { this.minSalary = minSalary; }

	public Double getMaxSalary() { return maxSalary; }

	public void setMaxSalary(Double maxSalary) { this.maxSalary = maxSalary; }

	public int getOpenPositionCount() { return openPositionCount; }

	public void setOpenPositionCount(int openPositionCount) { this.openPositionCount = openPositionCount; }

	public LocalDate getLastApplyDate() { return lastApplyDate; }

	public void setLastApplyDate(LocalDate lastApplyDate) { this.lastApplyDate = lastApplyDate; }

	public boolean isActive() { return isActive; }

	public void setActive(boolean isActive) { this.isActive = isActive; }

	public int getCityId() { return cityId; }

	public void setCityId(int cityId) { this.cityId = cityId; }

	public int getJobPositionId() { return jobPositionId; }

	public void setJobPositionId(int jobPositionId) { this.jobPositionId = jobPositionId; }

	public int getEmployerId() { return employerId; }

	public void setEmployerId(int employerId) { this.employerId = employerId; }
}
