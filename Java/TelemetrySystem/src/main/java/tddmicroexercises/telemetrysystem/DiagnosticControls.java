package tddmicroexercises.telemetrysystem;

public interface DiagnosticControls {

    public TelemetryClient getTelemetryClient();

    public void connect(String msg);

    public void disconnect();



}
