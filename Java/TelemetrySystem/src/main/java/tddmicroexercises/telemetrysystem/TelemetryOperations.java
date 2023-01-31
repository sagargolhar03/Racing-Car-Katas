package tddmicroexercises.telemetrysystem;

public class TelemetryOperations implements Operations {


    private final String DiagnosticChannelConnectionString;

    DiagnosticControls telemetryDiagnostic = new TelementryDiagnosticControlss();
    private String diagnosticInfo = "";

    public TelemetryOperations() {
        DiagnosticChannelConnectionString = "*111#";
    }

    @Override
    public void checkTransmission() throws Exception {
        diagnosticInfo = "";

        telemetryDiagnostic.disconnect();

        int retryLeft = 3;
        while (telemetryDiagnostic.getTelemetryClient().getOnlineStatus() == false && retryLeft > 0) {
            telemetryDiagnostic.connect(DiagnosticChannelConnectionString);
            retryLeft -= 1;
        }

        if (telemetryDiagnostic.getTelemetryClient().getOnlineStatus() == false) {
            throw new Exception("Unable to connect.");
        }

        telemetryDiagnostic.getTelemetryClient().send(TelemetryClient.DIAGNOSTIC_MESSAGE);
        diagnosticInfo = telemetryDiagnostic.getTelemetryClient().receive();
    }

    @Override
    public String getDiagnosticInfo() {
        return diagnosticInfo;
    }
}
