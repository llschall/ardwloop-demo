package ardwloop.demo.model;

import org.jetbrains.annotations.NotNull;
import org.llschall.ardwloop.serial.ArdwPortDescriptor;
import org.llschall.ardwloop.serial.DefaultPortSelector;
import org.llschall.ardwloop.serial.IArdwPortSelector;

import java.util.List;

public class CustomSelector implements IArdwPortSelector {

    final DefaultPortSelector selector = new DefaultPortSelector();

    @Override
    public boolean select(@NotNull ArdwPortDescriptor descriptor) {
        if (selector.select(descriptor)) return true;
        return descriptor.getName().contains("Arduino") || descriptor.getName().contains("CH340");
    }

    @NotNull
    @Override
    public List<ArdwPortDescriptor> list() {
        return selector.list();
    }
}