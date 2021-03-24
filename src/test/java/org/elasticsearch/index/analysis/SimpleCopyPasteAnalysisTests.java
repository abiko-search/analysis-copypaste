/*
 *   Copyright 2021 Danila Poyarkov <dev@dannote.net>
 *
 *   Licensed under the Apache License, Version 2.0 (the "License").
 *   You may not use this file except in compliance with the License.
 *   A copy of the License is located at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   or in the "license" file accompanying this file. This file is distributed
 *   on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 *   express or implied. See the License for the specific language governing
 *   permissions and limitations under the License.
 */

package org.elasticsearch.index.analysis;

import org.elasticsearch.Version;
import org.elasticsearch.cluster.metadata.IndexMetadata;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.index.Index;
import org.elasticsearch.plugin.analysis.AnalysisCopyPastePlugin;
import org.elasticsearch.test.ESTestCase;
import org.hamcrest.MatcherAssert;
import org.junit.Before;

import java.io.IOException;

import static org.hamcrest.Matchers.instanceOf;

public class SimpleCopyPasteAnalysisTests extends ESTestCase {

    private TestAnalysis analysis;

    @Before
    public void setup() throws IOException {
        Settings settings = Settings.builder()
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
                .build();
        this.analysis = createTestAnalysis(new Index("test", "_na_"), settings, new AnalysisCopyPastePlugin());
    }

    public void testCopyPasteFilterFactory() throws IOException {
        TokenFilterFactory filterFactory = analysis.tokenFilter.get("copypaste");
        MatcherAssert.assertThat(filterFactory, instanceOf(CopyPasteFilterFactory.class));
    }
}
