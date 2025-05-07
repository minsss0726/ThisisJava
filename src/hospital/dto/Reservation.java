package hospital.dto;

public class Reservation {
	private int reservationId;
	private int patientId;
	private String visitDate;
	private int departmentId;
	private int mainDoctorId;

	public int getMainDoctorId() {
		return mainDoctorId;
	}

	public void setMainDoctorId(int mainDoctorId) {
		this.mainDoctorId = mainDoctorId;
	}

	public int getReservationId() {
		return reservationId;
	}

	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(String visitDate) {
		this.visitDate = visitDate;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	@Override
	public String toString() {
		return "Reservation [reservationId=" + reservationId + ", patientId=" + patientId + ", visitDate=" + visitDate
				+ ", departmentId=" + departmentId + "]";
	}

}
