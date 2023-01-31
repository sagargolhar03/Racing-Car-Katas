package tddmicroexercises.telemetrysystem;

public class TelemetryOperations implements Operations {


    private final String DiagnosticChannelConnectionString;

    private final DiagnosticControls telemetryDiagnostic;
    private final Client telemetryClient;
    private String diagnosticInfo = "";

    public TelemetryOperations(DiagnosticControls telemetryDiagnostic, Client telemetryClient) {
        this.telemetryDiagnostic = telemetryDiagnostic;
        this.telemetryClient = telemetryClient;
        DiagnosticChannelConnectionString = "*111#";

    }

    @Override
    public void checkTransmission() throws Exception {
        diagnosticInfo = "";

        telemetryDiagnostic.disconnect();

        int retryLeft = 3;
        while (telemetryDiagnostic.getOnlineStatus() == false && retryLeft > 0) {
            telemetryDiagnostic.connect(DiagnosticChannelConnectionString);
            retryLeft -= 1;
        }

        if (telemetryDiagnostic.getOnlineStatus() == false) {
            throw new Exception("Unable to connect.");
        }

        telemetryClient.send(TelemetryClient.DIAGNOSTIC_MESSAGE);
        diagnosticInfo = telemetryClient.receive();
    }

    @Override
    public String getDiagnosticInfo() {
        return diagnosticInfo;
    }
}
