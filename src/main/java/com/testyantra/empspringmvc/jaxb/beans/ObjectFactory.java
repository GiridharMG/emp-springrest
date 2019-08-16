package com.testyantra.empspringmvc.jaxb.beans;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


@XmlRegistry
public class ObjectFactory {

    private final static QName _EmployeeDetails_QNAME = new QName("", "Employee_Details");

    public ObjectFactory() {
    }

    public EmployeeInfoBean createEmployeeInfoBean() {
        return new EmployeeInfoBean();
    }

    public EmployeeExperinceInfoBean createEmployeeExperinceInfoBean() {
        return new EmployeeExperinceInfoBean();
    }

    public TrainingInfoBean createTrainingInfoBean() {
        return new TrainingInfoBean();
    }

    public EmployeeEducationInfoBean createEmployeeEducationInfoBean() {
        return new EmployeeEducationInfoBean();
    }

    public DepartmentInfoBean createDepartmentInfoBean() {
        return new DepartmentInfoBean();
    }

    public EmployeeExperincePKBean createEmployeeExperincePKBean() {
        return new EmployeeExperincePKBean();
    }

    public EmployeeOtherInfoBean createEmployeeOtherInfoBean() {
        return new EmployeeOtherInfoBean();
    }

    public EmpRestResponse createEmpRestResponse() {
        return new EmpRestResponse();
    }

    public EmployeeAddressInfoBean createEmployeeAddressInfoBean() {
        return new EmployeeAddressInfoBean();
    }

    public EmployeeAddressPKBean createEmployeeAddressPKBean() {
        return new EmployeeAddressPKBean();
    }

    public EmployeeEducationPKBean createEmployeeEducationPKBean() {
        return new EmployeeEducationPKBean();
    }

    @XmlElementDecl(namespace = "", name = "Employee_Details")
    public JAXBElement<EmployeeInfoBean> createEmployeeDetails(EmployeeInfoBean value) {
        return new JAXBElement<EmployeeInfoBean>(_EmployeeDetails_QNAME, EmployeeInfoBean.class, null, value);
    }

}
