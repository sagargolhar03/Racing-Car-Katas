package tddmicroexercises.telemetrysystem;

public interface TelemetryDiagnosticInterface {

    public TelemetryClient getTelemetryClient();

    public void connect(String msg);

    public void disconnect();



}
