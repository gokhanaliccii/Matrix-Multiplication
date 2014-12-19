/**
 * MultiplicationService_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package service;

public interface MultiplicationService_PortType extends java.rmi.Remote {
    public java.lang.String deneme(java.lang.String name) throws java.rmi.RemoteException;
    public java.lang.String hello(java.lang.String name) throws java.rmi.RemoteException;
    public java.lang.Integer[][] multiplicationMatrices(java.lang.Integer[][] arg0, java.lang.Integer[][] arg1) throws java.rmi.RemoteException;
    public java.lang.String multiplication(java.lang.String matrix1, java.lang.String matrix2) throws java.rmi.RemoteException;
}
