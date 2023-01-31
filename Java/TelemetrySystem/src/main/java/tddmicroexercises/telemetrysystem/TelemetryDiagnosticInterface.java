package tddmicroexercises.telemetrysystem;

public interface TelemetryDiagnosticInterface {

    public void connect(String msg);

    public void disconnect();


    void checkTransmission() throws Exception;

    Object getDiagnosticInfo();
}
