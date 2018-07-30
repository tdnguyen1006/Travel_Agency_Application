/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2130f16asn2_nguyen_nguyen_miguel;

/**
 *
 * @author Tony
 */
public class Toan_Albert_Albryan_Flight extends Toan_Albert_Albryan_Passenger {
    private String FlightNumber, source, destination, dateleave, reservenumber;
    private double fare;
    
    public Toan_Albert_Albryan_Flight()
    {
        
    }
    
    public void setFligthno(String flightno)
    {
        FlightNumber = flightno;
    }
    
    public void setsrc(String src)
    {
        source = src;
    }
    
    public void setdest(String dest)
    {
        destination = dest;
    }
    
    public void setfare(double f)
    {
        fare = f;
    }
    
    public void setdateleaving(String datel)
    {
        dateleave = datel;
    }
    
    public void setreservenumber(String rn)
    {
        reservenumber = rn;
    }
    
    public String getFlightno()
    {
        return FlightNumber;
    }
    
    public String getSource()
    {
        return source;
    }
    
    public String getDest()
    {
        return destination;
    }
    
    public double getFare()
    {
        return fare;
    }
    
    public String getdateleaving()
    {
        return dateleave;
    }
    
    public String getreservenumber()
    {
        return reservenumber;
    }
    
    public double calculateTax()
    {
        double tax;
        tax = getFare( ) * 0.13;
        return tax;
    }
    
    public double calculateTotalFare()
    {
        double TotalFare;
        TotalFare = getFare() + calculateTax();
        return TotalFare;
    }
}
