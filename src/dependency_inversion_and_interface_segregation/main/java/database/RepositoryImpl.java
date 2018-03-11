package dependency_inversion_and_interface_segregation.main.java.database;

import utility.Constants;
import contracts.Modelable;
import contracts.Repository;
import exeptions.DuplicateModelException;
import exeptions.NonExistantModelException;

import java.util.HashMap;

public class RepositoryImpl<T extends Modelable> implements Repository {
    private HashMap<String, T> itemsByModel;

    public RepositoryImpl()
    {
        this.setItemsByModel(new HashMap<String, T>());
    }

    protected HashMap<String, T> getItemsByModel() {
        return this.itemsByModel;
    }

    protected void setItemsByModel(HashMap<String, T> itemsByModel) {
        this.itemsByModel = itemsByModel;
    }

    @Override
    public void Add(Modelable item) throws DuplicateModelException {
        if (this.itemsByModel.containsKey(item.getModel()))
        {
            throw new DuplicateModelException(Constants.DuplicateModelMessage);
        }

    }

    @Override
    public T GetItem(String model) throws NonExistantModelException {
        if (!this.itemsByModel.containsKey(model))
        {
            throw new NonExistantModelException(Constants.NonExistantModelMessage);
        }

        return this.itemsByModel.get(model);
    }

}
