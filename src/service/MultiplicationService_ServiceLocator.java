/**
 * MultiplicationService_ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package service;

public class MultiplicationService_ServiceLocator extends org.apache.axis.client.Service implements service.MultiplicationService_Service {

    public MultiplicationService_ServiceLocator() {
    }


    public MultiplicationService_ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public MultiplicationService_ServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for MultiplicationServicePort
    private java.lang.String MultiplicationServicePort_address = "http://localhost:8084/MultiplicationService/MultiplicationService";

    public java.lang.String getMultiplicationServicePortAddress() {
        return MultiplicationServicePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String MultiplicationServicePortWSDDServiceName = "MultiplicationServicePort";

    public java.lang.String getMultiplicationServicePortWSDDServiceName() {
        return MultiplicationServicePortWSDDServiceName;
    }

    public void setMultiplicationServicePortWSDDServiceName(java.lang.String name) {
        MultiplicationServicePortWSDDServiceName = name;
    }

    public service.MultiplicationService_PortType getMultiplicationServicePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(MultiplicationServicePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getMultiplicationServicePort(endpoint);
    }

    public service.MultiplicationService_PortType getMultiplicationServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            service.MultiplicationServicePortBindingStub _stub = new service.MultiplicationServicePortBindingStub(portAddress, this);
            _stub.setPortName(getMultiplicationServicePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setMultiplicationServicePortEndpointAddress(java.lang.String address) {
        MultiplicationServicePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (service.MultiplicationService_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                service.MultiplicationServicePortBindingStub _stub = new service.MultiplicationServicePortBindingStub(new java.net.URL(MultiplicationServicePort_address), this);
                _stub.setPortName(getMultiplicationServicePortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("MultiplicationServicePort".equals(inputPortName)) {
            return getMultiplicationServicePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://service/", "MultiplicationService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://service/", "MultiplicationServicePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("MultiplicationServicePort".equals(portName)) {
            setMultiplicationServicePortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
