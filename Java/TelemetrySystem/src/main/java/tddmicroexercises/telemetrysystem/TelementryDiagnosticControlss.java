package tddmicroexercises.telemetrysystem;

public class TelementryDiagnosticControlss implements DiagnosticControls {


    private final TelemetryClient telemetryClient;


    public TelementryDiagnosticControlss() {
        this.telemetryClient = new TelemetryClient();
        ;
    }

    @Override
    public TelemetryClient getTelemetryClient() {
        return telemetryClient;
    }

    @Override
    public void connect(String msg) {
        telemetryClient.connect(msg);
    }

    @Override
    public void disconnect() {
        telemetryClient.disconnect();
    }

}
