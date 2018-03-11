package exam_preparations.examIII.main.java.app.waste_disposal.manager;



import exam_preparations.examIII.main.java.app.waste_disposal.annotations.Burnable;
import exam_preparations.examIII.main.java.app.waste_disposal.annotations.Recyclable;
import exam_preparations.examIII.main.java.app.waste_disposal.annotations.Storable;
import exam_preparations.examIII.main.java.app.waste_disposal.contracts.GarbageProcessor;
import exam_preparations.examIII.main.java.app.waste_disposal.contracts.Manager;
import exam_preparations.examIII.main.java.app.waste_disposal.contracts.ProcessingData;
import exam_preparations.examIII.main.java.app.waste_disposal.contracts.Waste;
import exam_preparations.examIII.main.java.app.waste_disposal.entities.ProcessingDataImpl;
import exam_preparations.examIII.main.java.app.waste_disposal.factories.WasteFactory;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Chilly on 21.12.2017 г..
 */
public class ManagerImpl implements Manager {
    GarbageProcessor garbageProcessor;
    double totalEnergy;
    double totalCapital;
    private Map<String, ProcessingData> processDataForManagementRequirement;

    public ManagerImpl(GarbageProcessor garbageProcessor) {
        this.garbageProcessor = garbageProcessor;
        this.totalEnergy = 0;
        this.totalCapital = 0;
        this.setProcessDataForManagementRequirement();
    }

    @Override
    public String processGarbage(List<String> arguments) {
        String type = arguments.get(3);
        double weight = Double.parseDouble(arguments.get(1));
        String garbageName = arguments.get(0);

        return switchType(arguments, type, weight, garbageName);
    }

    @Override
    public String status() {
        return String.format("Energy: %.2f Capital: %.2f", this.totalEnergy, this.totalCapital);
    }

    @Override
    public String changeManagementRequirement(List<String> arguments) {
        String className = arguments.get(2);
        ProcessingData processingData = new ProcessingDataImpl(Double.parseDouble(arguments.get(0)), Double.parseDouble(arguments.get(1)));
       if (this.processDataForManagementRequirement.containsKey(className)) {
           this.processDataForManagementRequirement.replace(className, processingData);
       }
        return "Management requirement changed!";
    }

    private String switchType(List<String> arguments, String type, double weight, String garbageName) {
        switch (type) {
            case "Recyclable":
                Waste recyclable = WasteFactory.createRecyclable(garbageName, weight, Double.parseDouble(arguments.get(2)));
                ProcessingData recyclableProcessingData = this.garbageProcessor.processWaste(recyclable);
                if (this.processDataForManagementRequirement.get(type) != null) {
                    if (recyclableProcessingData.getEnergyBalance() >= this.processDataForManagementRequirement.get(type).getEnergyBalance()
                            && recyclableProcessingData.getCapitalBalance() >= this.processDataForManagementRequirement.get(type).getCapitalBalance()) {
                        this.updaiteProcessingData(recyclableProcessingData);
                    } else {
                        return "Processing Denied!";
                    }
                } else {
                    this.updaiteProcessingData(recyclableProcessingData);
                }

                return String.format("%.2f kg of %s successfully processed!", weight, recyclable.getName());
            case "Burnable":
                Waste burnable = WasteFactory.createBurnable(garbageName,weight, Double.parseDouble(arguments.get(2)));
                ProcessingData burnableProcessingData = this.garbageProcessor.processWaste(burnable);
                if (this.processDataForManagementRequirement.get(type) != null) {
                    if (burnableProcessingData.getEnergyBalance() >= this.processDataForManagementRequirement.get(type).getEnergyBalance()
                            && burnableProcessingData.getCapitalBalance() >= this.processDataForManagementRequirement.get(type).getCapitalBalance()) {
                        this.updaiteProcessingData(burnableProcessingData);
                    } else {
                        return "Processing Denied!";
                    }
                } else {
                    this.updaiteProcessingData(burnableProcessingData);
                }

                return String.format("%.2f kg of %s successfully processed!", weight, burnable.getName());
            case "Storable":
                Waste storable = WasteFactory.createStorable(garbageName, weight, Double.parseDouble(arguments.get(2)));
                ProcessingData storableProcessingData = this.garbageProcessor.processWaste(storable);
                if (this.processDataForManagementRequirement.get(type) != null) {
                    if (storableProcessingData.getEnergyBalance() >= this.processDataForManagementRequirement.get(type).getEnergyBalance()
                            && storableProcessingData.getCapitalBalance() >= this.processDataForManagementRequirement.get(type).getCapitalBalance()) {
                        this.updaiteProcessingData(storableProcessingData);
                    } else {
                        return "Processing Denied!";
                    }
                } else {
                    this.updaiteProcessingData(storableProcessingData);
                }

                return String.format("%.2f kg of %s successfully processed!", weight, storable.getName());
            default:
                return "";
        }
    }

    private void updaiteProcessingData (ProcessingData processingData) {
        this.totalEnergy += processingData.getEnergyBalance();
        this.totalCapital += processingData.getCapitalBalance();
    }

    private void setProcessDataForManagementRequirement() {
        this.processDataForManagementRequirement = new LinkedHashMap<>();
        this.processDataForManagementRequirement.put(Burnable.class.getSimpleName(), null);
        this.processDataForManagementRequirement.put(Recyclable.class.getSimpleName(), null);
        this.processDataForManagementRequirement.put(Storable.class.getSimpleName(), null);
    }
}