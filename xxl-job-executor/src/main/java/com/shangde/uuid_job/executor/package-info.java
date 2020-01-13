@DefaultResp(confs = {
        @DefaultRespConf(
                dataSourceId = "common_uuid",
                db = "common_uuid",
                includeTables = {"t_uuid_channel_field"}
        ),
})


package com.shangde.uuid_job.executor;

import com.shawn.ss.gen.api.interfaces.base_resp.DefaultResp;
import com.shawn.ss.gen.api.interfaces.base_resp.DefaultRespConf;