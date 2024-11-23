package ardwloop.demo.model;

import org.jetbrains.annotations.NotNull;
import org.llschall.ardwloop.serial.ArdwPortDescriptor;
import org.llschall.ardwloop.serial.DefaultPortSelector;
import org.llschall.ardwloop.serial.IArdwPortSelector;

import java.util.List;

public class CustomSelector implements IArdwPortSelector {

    final DefaultPortSelector delegate = new DefaultPortSelector();

    @Override
    public boolean select(@NotNull ArdwPortDescriptor descriptor) {
        return delegate.select(descriptor);
    }

    @NotNull
    @Override
    public List<ArdwPortDescriptor> list() {
        return delegate.list();
    }
}