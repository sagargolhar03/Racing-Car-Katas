package tddmicroexercises.telemetrysystem;

public interface DiagnosticControls {

   // public TelemetryClient getTelemetryClient();

    public boolean getOnlineStatus();

    public void connect(String msg);

    public void disconnect();



}
