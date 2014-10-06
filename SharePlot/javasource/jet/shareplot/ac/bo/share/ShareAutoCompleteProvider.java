package jet.shareplot.ac.bo.share;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import jet.components.ui.text.common.model.AutoCompleteContentProvider;
import jet.components.ui.text.common.model.AutoCompleteContentProviderChoices;

public class ShareAutoCompleteProvider implements AutoCompleteContentProvider {

    private final List<Share> shares;

    ShareAutoCompleteProvider(final ShareBOApplicationComponent shareAC) {
        this.shares = shareAC.getShares();
    }

    @Override
    public AutoCompleteContentProviderChoices getChoices(final String text) {
        final List<String> shareNames = new ArrayList<String>();
        shareNames.add("");

        for (final Share item : this.shares) {
            String key = item.getName();
            key = key.toLowerCase();
            int maxIdx = Math.min(key.length(), text.length());
            maxIdx = Math.max(maxIdx, 1);
            final String prefix = text.toLowerCase().substring(0, maxIdx - 1);
            if (key.startsWith(prefix)) {
                shareNames.add(item.getName());
            }
        }

        final String[] names = shareNames.toArray(new String[shareNames.size()]);

        return new AutoCompleteContentProviderChoices(names, true, "(.*)\\u0000(\\1.*)");
    }

    /**
     * Get the Share of a given name.
     * 
     * @param shareName Name of the desired Share
     * @return Desired Share, may be <code>null</code> if the Share is unknown
     */
    @Nullable
    public Share getShare(@NonNull final String shareName) {
        Share result = null;
        for (final Share item : this.shares) {
            if (shareName.equals(item.getName())) {
                result = item;
                break;
            }
        }
        return result;
    }

}
