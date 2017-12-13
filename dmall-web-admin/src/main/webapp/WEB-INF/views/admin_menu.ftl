<#if menuArr?? && menuArr?size &gt; 0>
	<@showMenu menuArr = menuArr parentId = '0' />
</#if>

<#macro showMenu menuArr parentId>
	<#if menuArr?? >
		<#list menuArr as m>
			<#if m?? && m.parentId==parentId>
				<#if m.hasChild?? && m.hasChild=='1'>
                <li><a href="javascript:void(0);">
					<#if m.icon??><i class="fa ${m.icon?html}"></i></#if>
                    <span><#if m.name??><#if m.name?starts_with("?")>${(m.name)?html}<#else>${m.name?html}</#if><#else>--</#if></span></a>
                    <ul class='acc-menu'>
						<@showMenu menuArr = menuArr parentId = m.id />
                    </ul>
				<#else>
                <li><a href="<#if m.url??>${request.contextPath}/admin/${m.url}<#else>#</#if>">
					<#if m.icon??><i class="fa ${m.icon?html}"></i></#if>
                    <span><#if m.name??><#if m.name?starts_with("?")>${(m.name)?html}<#else>${m.name?html}</#if><#else>--</#if></span></a>
                </li>
				</#if>
			</#if>
		</#list>
	</#if>
</#macro>
